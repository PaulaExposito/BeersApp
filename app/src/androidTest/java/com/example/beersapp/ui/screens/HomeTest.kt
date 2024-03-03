package com.example.beersapp.ui.screens

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.SavedStateHandle
import com.example.beersapp.services.BeersRepository
import com.example.beersapp.ui.viewmodels.BeersViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeTest {

//    @RelaxedMockK
//    private lateinit var savedStateHandle : SavedStateHandle
//
//    @RelaxedMockK
//    private lateinit var beersRepository : BeersRepository
//
//    @RelaxedMockK
//    private lateinit var viewModel: BeersViewModel

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun onBefore () {
//        MockKAnnotations.init(this)
//        viewModel = BeersViewModel(savedStateHandle, beersRepository)
    }

//    @Test
//    fun homeTest_PassViewModelToScreen_ScreenShowsTitle () {
//        composeTestRule.setContent {
//            HomeScreen(viewModel = viewModel)
//        }
//
//        composeTestRule
//            .onNodeWithText("Random Beers")
//            .assertExists()
//    }

    @Test
    fun homeTest_TitleComponentDisplaysTheTitle () {
        composeTestRule.setContent {
            Title()
        }

        composeTestRule
            .onNodeWithText("Random Beers")
            .assertExists()
    }
}