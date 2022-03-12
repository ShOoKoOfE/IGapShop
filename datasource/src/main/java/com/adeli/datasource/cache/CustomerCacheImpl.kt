package com.adeli.datasource.cache

import com.adeli.datasource.network.model.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CustomerCacheImpl @Inject constructor (
    private val databaseOperations: CustomerDatabaseOperations
) : CustomerCache{
    override fun insertCustomer(customers: List<Customer>): Flow<CustomerDataStatus> = flow {
        emit(CustomerDataStatus.Loading)
        for(customer in customers){
            try {
                databaseOperations.insertCustomer(customer.id,customer.email,customer.firstName,customer.lastName,customer.username)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        emit(CustomerDataStatus.Added)
    }.flowOn(Dispatchers.IO)

    override fun retrieveCustomers(): Flow<CustomerDataStatus> = flow {
        emit(CustomerDataStatus.Loading)
        val customers = databaseOperations.retrieveCustomers()
        emit(CustomerDataStatus.CustomerListResult(customers))
    }.flowOn(Dispatchers.IO)

    override fun getCustomer(email: String): Flow<Customer> = flow {
        val customer = databaseOperations.getCustomer(email)
        emit(customer)
    }.flowOn(Dispatchers.IO)

}