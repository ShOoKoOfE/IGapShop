package com.adeli.igapshop.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.ImageLoader
import com.adeli.ui_productlist.ui.ProductListItem
import com.adeli.ui_productlist.ui.ProductListState

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun ProductList(
    navController: NavController,
    state: ProductListState,
    imageLoader: ImageLoader,
){
    DefaultScreenUI(
        navController = navController,
        progressBarState = state.progressBarState,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
                modifier = Modifier
                    .clickable {}
            ){
                AnimatedVisibility(visible = true) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp)
                    ) {
                        items(state.products){ product ->
                            ProductListItem(
                                product = product,
                                imageLoader = imageLoader
                            )
                        }
                    }
                }
            }
        }
    }
}
