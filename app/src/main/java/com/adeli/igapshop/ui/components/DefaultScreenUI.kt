package com.adeli.igapshop.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.adeli.core.domain.ProgressBarState
import com.adeli.core.domain.UIComponentState
import com.adeli.igapshop.ui.navigation.Screen
import com.adeli.ui_login.ui.GenericDialog
import com.adeli.ui_login.ui.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun DefaultScreenUI(
    progressBarState: ProgressBarState = ProgressBarState.Idle,
    uiComponentState: UIComponentState = UIComponentState.Hide,
    content: @Composable () -> Unit,
){
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar={
            TopAppBar(
                title = {
                    Text(
                        text = "IGap Shop",
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.List,
                            contentDescription = "Drawer Button"
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                currentScreen = Screen.ProductList,
                closeDrawerAction = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        }
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ){
            content()
            if(progressBarState is ProgressBarState.Loading){
                CircularIndeterminateProgressBar()
            }
            if(uiComponentState is UIComponentState.Show){
                GenericDialog(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    title = "Notice",
                    description = "Please Enter Your Email & Password",
                    mutableState = viewModel<LoginViewModel>().state
                )
            }
        }
    }
}

