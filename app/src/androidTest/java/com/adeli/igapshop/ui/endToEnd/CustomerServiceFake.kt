package com.adeli.igapshop.ui.endToEnd

import com.adeli.datasource.network.ProductService
import com.adeli.datasource.network.ProductServiceImpl
import com.adeli.igapshop.Utils.Companion.mockResponseFileReader
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class CustomerServiceFake {
    companion object Factory {
        fun build(): ProductServiceImpl {
            val mockWebServer = MockWebServer()
            val logger = HttpLoggingInterceptor()
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            val productService = Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(ProductService::class.java)
            val mockResponse = MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                mockResponseFileReader("data/CustomerData.json")
            )
            mockWebServer.enqueue(mockResponse)
            return ProductServiceImpl(productService)
        }
    }
}