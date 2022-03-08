package com.adeli.ui_productlist.ui

import com.adeli.core.domain.UIComponent

sealed class ProductListEvents{
    object GetProducts: ProductListEvents()
    data class Error(
        val uiComponent: UIComponent
    ): ProductListEvents()
}