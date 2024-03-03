package com.example.beersapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beersapp.config.Config.Companion.NUMBER_OF_BEERS
import com.example.beersapp.config.Config.Companion.SAVE_STATE_BEERS_KEY
import com.example.beersapp.models.Beer
import com.example.beersapp.services.BeersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BeersViewModel @Inject constructor (
    private val savedState: SavedStateHandle,
    private val beersRepository: BeersRepository
) : ViewModel() {

    private val beers_ = savedState.getLiveData(SAVE_STATE_BEERS_KEY, initialValue = emptyList<Beer>())
    val beers : LiveData<List<Beer>> = beers_

    private val isLoading_ = MutableLiveData(false)
    val isLoading : LiveData<Boolean> = isLoading_

    init {
        if (beers_.value != null && beers_.value!!.isEmpty())
            onRefreshBeers()
    }

    fun onRefreshBeers () {
        viewModelScope.launch {
            isLoading_.value = true
            beers_.value = beersRepository.getBeers(NUMBER_OF_BEERS)
            isLoading_.value = false
        }
    }
}