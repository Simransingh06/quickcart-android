package com.simransingh.quickcart.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val category: String
)

interface ApiService {
    @GET("products")
    suspend fun getInstantProducts(): List<ProductDto>

    @GET("products/search")
    suspend fun searchProducts(@Query("q") query: String): List<ProductDto>
}
