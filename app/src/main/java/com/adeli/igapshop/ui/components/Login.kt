package com.adeli.igapshop.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adeli.core.domain.EmailState
import com.adeli.ui_login.ui.LoginFields
import com.adeli.ui_login.ui.LoginState
import com.adeli.ui_login.ui.LoginViewModel

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Login(
    navController: NavController,
    state: LoginState,
    viewModel: LoginViewModel
){
    DefaultScreenUI(
        navController = navController,
        progressBarState = state.progressBarState,
        uiComponentState = state.uiComponentState
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        val focusManager = LocalFocusManager.current
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxSize()
                    .clickable { focusManager.clearFocus() }
            ){
                AnimatedVisibility(visible = true) {
                    if (state.emailState is EmailState.Reject) {
                        LoginFields(
                            email,
                            password,
                            onLoginClick = {
                                viewModel.login(email, password)
                            },
                            onEmailChange = { email = it },
                            onPasswordChange = { password = it }
                        )
                    } else {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "WellCome!!!",
                                fontSize = MaterialTheme.typography.h3.fontSize,
                                modifier = Modifier.padding(16.dp)
                            )
                            Text(
                                text = "${state.fullName}",
                                fontSize = MaterialTheme.typography.h4.fontSize,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


