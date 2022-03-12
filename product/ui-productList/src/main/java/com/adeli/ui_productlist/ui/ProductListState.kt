package com.adeli.ui_productlist.ui

import com.adeli.core.domain.ProgressBarState
import com.adeli.datasource.network.model.Product

/**
 * @param progressBarState: State of the progress bar in UI.
 * @param products: list of products.
 */

data class ProductListState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val products: List<Product> = listOf()
)
