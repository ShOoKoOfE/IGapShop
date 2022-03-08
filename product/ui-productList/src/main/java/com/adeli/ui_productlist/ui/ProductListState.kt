package com.adeli.ui_productlist.ui

import com.adeli.core.domain.*
import com.adeli.datasource.network.model.Customer
import com.adeli.datasource.network.model.Product

data class ProductListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val products: List<Product> = listOf()
)
