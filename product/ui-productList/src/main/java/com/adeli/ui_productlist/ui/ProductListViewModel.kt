package com.adeli.ui_productlist.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.adeli.core.domain.ProgressBarState
import com.adeli.core.domain.UIComponent
import com.adeli.core.utils.Logger
import com.adeli.datasource.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: Repository,
    private val logger: Logger
) : ViewModel(){
    val state: MutableState<ProductListState> = mutableStateOf(ProductListState())
    init {
        state.value = state.value.copy(progressBarState = ProgressBarState.Loading)
        onTriggerEvent(ProductListEvents.GetProducts)
    }

    private fun onTriggerEvent(event: ProductListEvents){
        when(event){
            is ProductListEvents.GetProducts -> {
                getProduct()
            }
            is ProductListEvents.Error -> {
                if(event.uiComponent is UIComponent.None){
                    logger.log("getProducts: ${(event.uiComponent as UIComponent.None).message}")
                }
            }
        }
    }
    private fun getProduct()=viewModelScope.launch {
        repository.getProductList().collect(){values ->
            state.value = state.value.copy(products = values.data?: listOf())
            state.value = state.value.copy(progressBarState = ProgressBarState.Idle)
        }
    }
}