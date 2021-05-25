package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.compose.rally.ui.overview.OverviewBody
import org.junit.Rule
import org.junit.Test

class OverviewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun overviewScreen_alertsDisplayed() {
        composeTestRule.setContent {
            OverviewBody()
        }

        // For this test to pass, we have to wait for the animations to finish
        // (this is called synchronization).
        // That's why for infinite animations we have to use special animations,
        // which Compose tests understand - see AlertCard in OverviewScreen.kt for details.
        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()
    }
}
