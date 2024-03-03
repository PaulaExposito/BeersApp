package com.example.beersapp.ui.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.beersapp.services.BeersRepository
import com.example.beersapp.ui.viewmodels.BeersViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AppNavigationTest {

    lateinit var navController: TestNavHostController

    @RelaxedMockK
    private lateinit var savedStateHandle : SavedStateHandle

    @RelaxedMockK
    private lateinit var beersRepository : BeersRepository

    @RelaxedMockK
    private lateinit var viewModel: BeersViewModel

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setupAppNavHost () {
        composeTestRule.setContent {
//            MockKAnnotations.init(this)
//            viewModel = BeersViewModel(savedStateHandle, beersRepository)
//
//            navController = TestNavHostController(LocalContext.current)
//            navController.navigatorProvider.addNavigator(ComposeNavigator())
//            AppNavigation (navController = navController, beersViewModel = viewModel)
        }
    }

//    @Test
//    fun appNavHost_verifyStartDestination () {
//        composeTestRule
//            .onNodeWithContentDescription("Home Screen")
//            .assertIsDisplayed()
//    }
}