package com.adeli.ui_login.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.adeli.core.domain.EmailState
import com.adeli.core.domain.ProgressBarState
import com.adeli.core.domain.UIComponent
import com.adeli.core.domain.UIComponentState
import com.adeli.core.utils.Logger
import com.adeli.datasource.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository,
    private val logger: Logger
) : ViewModel(){
    var state: MutableState<LoginState> = mutableStateOf(LoginState())
    init {
        state.value = state.value.copy(progressBarState = ProgressBarState.Loading)
        state.value = state.value.copy(emailState = EmailState.Reject)
        state.value = state.value.copy(uiComponentState = UIComponentState.Hide)
        onTriggerEvent(LoginEvents.GetCustomers)
    }

    private fun onTriggerEvent(event: LoginEvents){
        when(event){
            is LoginEvents.GetCustomers -> {
                getCustomer()
            }
            is LoginEvents.Error -> {
                if(event.uiComponent is UIComponent.None){
                    logger.log("getProducts: ${(event.uiComponent as UIComponent.None).message}")
                }
            }
        }
    }
    private fun getCustomer()=viewModelScope.launch {
        repository.getCustomerList().collect(){values ->
            state.value = state.value.copy(customers = values.data?: listOf())
            state.value = state.value.copy(progressBarState = ProgressBarState.Idle)
        }
    }

    fun login(email: String, password: String) {
        if (!email.isBlank() && !password.isBlank()){
            state.value = state.value.copy(uiComponentState = UIComponentState.Hide)
            state.value = state.value.copy(progressBarState = ProgressBarState.Loading)
            val findCustomer = state.value.customers.find { customer -> customer.email == email.trim() }
            state.value = state.value.copy(progressBarState = ProgressBarState.Idle)
            if (findCustomer!=null){
                state.value = state.value.copy(emailState = EmailState.Accept)
                state.value = state.value.copy(fullName = findCustomer.firstName + " " + findCustomer.lastName)
            } else{
                state.value = state.value.copy(emailState = EmailState.Reject)
            }
        } else {
            state.value = state.value.copy(uiComponentState = UIComponentState.Show)
        }
    }
}