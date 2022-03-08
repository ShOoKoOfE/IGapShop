package com.adeli.datasource.network

import com.adeli.datasource.network.model.Customer
import com.adeli.datasource.network.model.Product
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ActivityRetainedScoped
class Repository @Inject constructor(
    private val productServiceImpl: ProductServiceImpl
) : BaseApiResponse() {

    suspend fun getProductList(): Flow<NetworkResult<List<Product>>> {
        return flow<NetworkResult<List<Product>>> {
            emit(safeApiCall { productServiceImpl.getProductList() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCustomerList(): Flow<NetworkResult<List<Customer>>> {
        return flow<NetworkResult<List<Customer>>> {
            emit(safeApiCall { productServiceImpl.getCustomerList() })
        }.flowOn(Dispatchers.IO)
    }

}