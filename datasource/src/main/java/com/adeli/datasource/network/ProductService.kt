package com.adeli.datasource.network

import com.adeli.datasource.network.model.Customer
import com.adeli.datasource.network.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("products?consumer_key=ck_e649ccf09f6c55391b196c11747a6881b651dd41&consumer_secret=cs_386c57bfe7de869709e0b3f98bca137e37a8a62d")
    suspend fun getProductList(): Response<List<Product>>
    @GET("customers?consumer_key=ck_e649ccf09f6c55391b196c11747a6881b651dd41&consumer_secret=cs_386c57bfe7de869709e0b3f98bca137e37a8a62d")
    suspend fun getCustomerList(): Response<List<Customer>>
}