package network

import network.Utils.Companion.mockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import java.net.HttpURLConnection

class ProductServiceResponseMock {
    companion object Factory {
        fun build(
            type: ProductServiceResponseType
        ): MockResponse {
            val mockResponse = MockResponse()
            when (type) {
                is ProductServiceResponseType.EmptyList -> {
                    mockResponse.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND).setBody(
                        mockResponseFileReader("data/EmptyData.json")
                    )
                }
                is ProductServiceResponseType.MalformedData -> {
                    mockResponse.setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                        mockResponseFileReader("data/MalformedData.json")
                    )
                }
                is ProductServiceResponseType.GoodData -> {
                    mockResponse.setResponseCode(HttpURLConnection.HTTP_OK).setBody(
                        mockResponseFileReader("data/ValidData.json")
                    )
                }
                is ProductServiceResponseType.Http404 -> {
                    mockResponse.setResponseCode(HttpURLConnection.HTTP_NOT_FOUND).setBody(
                        mockResponseFileReader("data/EmptyData.json")
                    )
                }
            }
            return mockResponse
        }
    }
}