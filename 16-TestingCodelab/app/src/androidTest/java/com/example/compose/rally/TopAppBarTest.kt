package com.example.compose.rally

import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // We can start an activity like this
    // @get:Rule
    // val composeTestRule = createAndroidComposeRule(RallyActivity::class.java)
    // but it is much easier to test a component in isolation using setContent.

    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        // This is needed just to see, what's going on. It is not required for testing
        Thread.sleep(5000)
    }
}
