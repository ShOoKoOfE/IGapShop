package com.adeli.datasource.network.model


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("collection")
    val collection: List<CollectionX>,
    @SerializedName("self")
    val self: List<SelfX>
)