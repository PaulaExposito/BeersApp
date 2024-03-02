package com.example.beersapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.beersapp.core.Config.Companion.NUMBER_OF_BEERS
import com.example.beersapp.core.Config.Companion.SAVE_STATE_BEERS_KEY
import com.example.beersapp.models.Beer
import com.example.beersapp.services.BeersService
import kotlinx.coroutines.launch

class BeersViewModel (savedState: SavedStateHandle) : ViewModel() {

    private val beersService = BeersService()

    private val beers_ = savedState.getLiveData(SAVE_STATE_BEERS_KEY, initialValue = emptyList<Beer>())
    val beers : LiveData<List<Beer>> = beers_

    init {
        if (beers_.value!!.isEmpty())
            onRefreshBeers()
    }

    fun onRefreshBeers () {
        viewModelScope.launch {
            beers_.value = beersService.getBeers(NUMBER_OF_BEERS)
        }
    }
}