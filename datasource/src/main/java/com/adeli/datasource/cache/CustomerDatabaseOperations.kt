package com.adeli.datasource.cache

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.adeli.datasource.network.model.Customer
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CustomerDatabaseOperations @Inject constructor(private val realm: Realm) {

    suspend fun insertCustomer(id: Int, email: String, firstName: String, lastName: String, username: String) {
        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            val customer = CustomerRealm(id = id, email = email, firstName = firstName, lastName = lastName, username = username)
            realmTransaction.insert(customer)
        }
    }

    suspend fun retrieveCustomers(): List<Customer> {
        val customers = mutableListOf<Customer>()

        realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
            customers.addAll(realmTransaction
                .where(CustomerRealm::class.java)
                .findAll()
                .map { customer ->
                    Customer(
                        id = customer.id,
                        email = customer.email,
                        firstName = customer.firstName,
                        lastName = customer.lastName,
                        username = customer.username
                    )
                }
            )
        }
        return customers
    }

    suspend fun getCustomer(email: String): Customer {
        var customer : MutableState<Customer> = mutableStateOf(Customer())
         realm.executeTransactionAwait(Dispatchers.IO) { realmTransaction ->
             customer.value = realmTransaction.where(CustomerRealm::class.java)
                 .equalTo("email", email)
                 .findFirst()?.let { mapCustomer(it) }!!
        }
        return customer.value
    }

    private fun mapCustomer(customer: CustomerRealm): Customer {
        return Customer(
            id = customer.id,
            email = customer.email,
            firstName = customer.firstName,
            lastName = customer.lastName,
            username = customer.username,
        )
    }
}
