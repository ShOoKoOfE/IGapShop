package com.adeli.datasource.cache

import com.adeli.datasource.network.model.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerCache {
    fun insertCustomer(customers: List<Customer>):Flow<CustomerDataStatus>
    fun retrieveCustomers():Flow<CustomerDataStatus>
    fun getCustomer(email: String):Flow<Customer>
}