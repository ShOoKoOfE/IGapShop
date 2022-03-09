package network

import com.adeli.datasource.network.ProductService
import com.adeli.datasource.network.ProductServiceImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductServiceFake {
    companion object Factory {
        fun build(
            type: ProductServiceResponseType
        ): ProductServiceImpl {
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
            val mockResponse = ProductServiceResponseMock.build(type = type)
            mockWebServer.enqueue(mockResponse)
            return ProductServiceImpl(productService)
        }
    }
}