package com.adeli.datasource.network

import javax.inject.Inject

class ProductServiceImpl  @Inject constructor(private val productService: ProductService) {
    suspend fun getProductList() = productService.getProductList()
    suspend fun getCustomerList() = productService.getCustomerList()
}