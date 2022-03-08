package com.adeli.ui_login.ui

import com.adeli.core.domain.UIComponent

sealed class LoginEvents{
    object GetCustomers: LoginEvents()
    data class Error(
        val uiComponent: UIComponent
    ): LoginEvents()
}
