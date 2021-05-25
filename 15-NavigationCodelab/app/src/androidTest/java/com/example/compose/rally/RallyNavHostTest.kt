package com.example.compose.rally

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.fail

class RallyNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyNavHost() {
        composeTestRule.setContent {
            val navController = rememberNavController()
            RallyNavHost(navController = navController)
        }

        // Assertions have to be written outside of the setContent function
        fail()
    }
}
