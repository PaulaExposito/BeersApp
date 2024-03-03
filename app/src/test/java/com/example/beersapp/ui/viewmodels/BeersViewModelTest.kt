package com.example.beersapp.ui.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.beersapp.services.BeersRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule

class BeersViewModelTest {

    @RelaxedMockK
    private lateinit var savedStateHandle : SavedStateHandle

    @RelaxedMockK
    private lateinit var beersRepository : BeersRepository

    @RelaxedMockK
    private lateinit var viewModel: BeersViewModel

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun onBefore () {
        MockKAnnotations.init(this)
        viewModel = BeersViewModel(savedStateHandle, beersRepository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter () {
        Dispatchers.resetMain()
    }

    //Using private val beers_ = MutableLiveData<List<Beer>>() instead on SavedStateHandle
//    @Test
//    fun beersViewModel_SuccessfulDataDownloaded_BeersIsNotEmptyAndLoadingIsFalse () = runTest {
//        val currentBeers = listOf(Beer("Estrella Galicia", "1906", "rubia", "9%"))
//        coEvery { beersRepository.getBeers(Config.NUMBER_OF_BEERS) } returns currentBeers
//
//        viewModel.onRefreshBeers()
//
//        assertEquals(currentBeers, viewModel.beers.value)
//        assertEquals(false, viewModel.isLoading.value)
//    }
//
//    @Test
//    fun beersViewModel_SuccessfulSavedSavedStateHandle_SavedStateHandleContainBeersKey () = runTest {
//        viewModel.onRefreshBeers()
//        coVerify { savedStateHandle[Config.SAVE_STATE_BEERS_KEY] = emptyList<Beer>() }
//    }
}