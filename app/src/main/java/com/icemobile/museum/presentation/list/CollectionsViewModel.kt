package com.icemobile.museum.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icemobile.museum.domain.usecase.get_collections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.businesscard.bcard.common.Response
import ir.businesscard.bcard.domain.use_case.get_coin.GetCoinUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val useCase: GetCollectionsUseCase
) : ViewModel() {

    private val status = MutableLiveData<CollectionsState>()

    fun getStatus(): LiveData<CollectionsState> {
        return status
    }

    init {
        getCoins()
    }

    private fun getCoins() {
        useCase.execute().onEach {
            when (it) {
                is Response.Error -> {
                    status.postValue(
                        CoinsListState(
                            error = it.message ?: "An unexpected error occurred"
                        )
                    )
                }
                is Response.Loading -> {
                    status.postValue(CoinsListState(isLoading = true))
                }
                is Response.Success -> {
                    status.postValue(CoinsListState(coins = it.data ?: emptyList()))
                }
            }
        }.launchIn(viewModelScope)
    }
}