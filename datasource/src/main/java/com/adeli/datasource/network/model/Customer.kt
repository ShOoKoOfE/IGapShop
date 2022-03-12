package com.adeli.datasource.network.model


import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("email")
    val email: String = "",
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("last_name")
    val lastName: String = "",
    @SerializedName("username")
    val username: String = ""
)