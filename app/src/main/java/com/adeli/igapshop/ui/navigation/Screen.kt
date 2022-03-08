package com.adeli.igapshop.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route:String,
    val arguments:List<NamedNavArgument>
){
    object Login:Screen(
        route = "login",
        arguments = emptyList()
    )
    object ProductList:Screen(
        route = "productList",
        arguments = emptyList()
    )
}