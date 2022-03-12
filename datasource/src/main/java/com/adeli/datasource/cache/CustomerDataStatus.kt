package com.adeli.datasource.cache

import com.adeli.datasource.network.model.Customer

sealed class CustomerDataStatus{
    object Loading : CustomerDataStatus()
    object Added : CustomerDataStatus()
    data class CustomerListResult(val customerList: List<Customer>) : CustomerDataStatus()
}
