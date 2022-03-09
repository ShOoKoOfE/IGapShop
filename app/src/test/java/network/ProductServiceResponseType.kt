package network

sealed class ProductServiceResponseType {
    object EmptyList: ProductServiceResponseType()
    object MalformedData: ProductServiceResponseType()
    object GoodData: ProductServiceResponseType()
    object Http404: ProductServiceResponseType()
}
