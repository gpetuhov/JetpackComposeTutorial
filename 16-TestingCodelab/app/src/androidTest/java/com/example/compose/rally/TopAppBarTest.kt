package com.example.compose.rally

import androidx.compose.ui.test.*
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
    fun rallyTopAppBarTest_currentTabSelected() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        // Look for a content description and asserts that it exists.
        // To set content description use:
        // Modifier.clearAndSetSemantics { contentDescription = text }
        // which clears the properties from descendants
        // and sets its own content description.
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        // You can print the Semantics tree using the printToLog function on a node.
        // This can help in debugging tests that fail.
        // in order to see the Semantics tree for the descendants of the node,
        // pass useUnmergedTree = true
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertExists()

        // Here we pass useUnmergedTree = true,
        // because we have to check the descendant with the specified text.
        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.toUpperCase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }
}
