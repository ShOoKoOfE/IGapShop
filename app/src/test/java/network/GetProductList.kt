package network

import com.adeli.datasource.network.Repository
import com.adeli.datasource.network.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetProductList {
    private lateinit var repository : Repository

    @Test
    fun getProducts_success() =  runBlocking {
        val productServiceImpl = ProductServiceFake.build(
            type = ProductServiceResponseType.GoodData
        )
        val  actualResponse = productServiceImpl.getProductList()
        val mockResponse = ProductServiceResponseMock.build(
            type = ProductServiceResponseType.GoodData
        )

        repository = Repository(productServiceImpl)

        Assert.assertEquals(
            mockResponse.toString().contains("200"),
            actualResponse.code().toString().contains("200")
        )
    }

    @Test
    fun getProducts_emptyList() =  runBlocking {
        val productServiceImpl = ProductServiceFake.build(
            type = ProductServiceResponseType.Http404
        )
        val  actualResponse = productServiceImpl.getProductList()
        val mockResponse = ProductServiceResponseMock.build(
            type = ProductServiceResponseType.Http404
        )

        repository = Repository(productServiceImpl)

        Assert.assertEquals(
            mockResponse.toString().contains("404"),
            actualResponse.code().toString().contains("404")
        )
    }

    @Test
    fun `fetch details and check response success returned`() = runBlocking {
        val productServiceImpl = ProductServiceFake.build(
            type = ProductServiceResponseType.GoodData
        )
        val  actualResponse = productServiceImpl.getProductList().body()
        val mockResponse : List<Product> = Gson().fromJson(
            ProductServiceResponseMock.build(
                type = ProductServiceResponseType.GoodData
            ).getBody()?.readUtf8(), object : TypeToken<List<Product>>() {}.type)
        Assert.assertEquals(mockResponse[0].images, actualResponse?.get(0)?.images)
    }
}