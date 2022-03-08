package com.adeli.ui_login.ui

import com.adeli.core.domain.EmailState
import com.adeli.core.domain.ProgressBarState
import com.adeli.core.domain.UIComponentState
import com.adeli.datasource.network.model.Customer

data class LoginState (
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val customers: List<Customer> = listOf(),
    val emailState: EmailState = EmailState.Reject,
    val fullName:String = "",
    val uiComponentState: UIComponentState = UIComponentState.Hide
)