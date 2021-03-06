/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.compose.rally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navDeepLink
import com.example.compose.rally.data.UserData
import com.example.compose.rally.ui.accounts.AccountsBody
import com.example.compose.rally.ui.accounts.SingleAccountBody
import com.example.compose.rally.ui.bills.BillsBody
import com.example.compose.rally.ui.components.RallyTabRow
import com.example.compose.rally.ui.overview.OverviewBody
import com.example.compose.rally.ui.theme.RallyTheme

/**
 * This Activity recreates part of the Rally Material Study from
 * https://material.io/design/material-studies/rally.html
 */
class RallyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RallyApp()
        }
    }
}

@Composable
fun RallyApp() {
    RallyTheme {
        val allScreens = RallyScreen.values().toList()

        // Obtain a NavController by using the rememberNavController() function;
        // this creates and remembers a NavController which survives configuration changes
        // (using rememberSavable).
        // It is better to keep the navController at the top level of your navigation hierarchy
        // and not pass it directly into child composables (instead use callbacks, when needed).
        val navController = rememberNavController()

        // Navigation holds on to the back stack for you
        // and can provide you with the current back stack entry as a State.
        val backstackEntry = navController.currentBackStackEntryAsState()

        // currentScreen uses the navigation backstack like this
        val currentScreen = RallyScreen.fromRoute(
            backstackEntry.value?.destination?.route
        )

        Scaffold(
            topBar = {
                RallyTabRow(
                    allScreens = allScreens,
                    onTabSelected = { screen ->
                        navController.navigate(screen.name)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            RallyNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

// This is the one and only composable you should work directly with the navController
@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    // The NavHost links the NavController with a navigation graph
    // where composable destinations are specified.
    NavHost(
        navController = navController,
        startDestination = RallyScreen.Overview.name,
        modifier = modifier
    ) {
        // Here we declare navigation graph

        composable(RallyScreen.Overview.name) {
            OverviewBody(
                onClickSeeAllAccounts = { navController.navigate(RallyScreen.Accounts.name) },
                onClickSeeAllBills = { navController.navigate(RallyScreen.Bills.name) },
                onAccountClick = { name ->
                    navigateToSingleAccount(navController, name)
                }
            )
        }
        composable(RallyScreen.Accounts.name) {
            AccountsBody(accounts = UserData.accounts) { name ->
                navigateToSingleAccount(
                    navController = navController,
                    accountName = name
                )
            }
        }
        composable(RallyScreen.Bills.name) {
            BillsBody(bills = UserData.bills)
        }

        val accountsName = RallyScreen.Accounts.name

        // Destination with named argument
        composable(
            route = "$accountsName/{name}",
            arguments = listOf(
                navArgument("name") {
                    // Make argument type safe
                    type = NavType.StringType
                }
            ),
            // Enable deep links from outside your app to individual accounts directly by name.
            // For this to work don't forget to add an intent filter for RallyActivity
            // in the manifest.
            // To test deep links run this command from the command line:
            // adb shell am start -d "rally://accounts/Checking" -a android.intent.action.VIEW
            deepLinks =  listOf(navDeepLink {
                uriPattern = "rally://$accountsName/{name}"
            })
        ) { entry ->
            // The body of each composable destination receives a parameter
            // of the current NavBackStackEntry which models the route and arguments
            // of the current destination. We can use arguments to retrieve the argument
            // (name in our example)

            // Look up "name" in NavBackStackEntry's arguments
            val accountName = entry.arguments?.getString("name")
            // Find first name match in UserData
            val account = UserData.getAccount(accountName)
            // Pass account to SingleAccountBody
            SingleAccountBody(account = account)
        }
    }
}

private fun navigateToSingleAccount(
    navController: NavHostController,
    accountName: String
) {
    navController.navigate("${RallyScreen.Accounts.name}/$accountName")
}