package com.simransingh.quickcart.data

import com.simransingh.quickcart.data.local.CartDao
import com.simransingh.quickcart.data.local.CartItem
import com.simransingh.quickcart.data.remote.ApiService
import com.simransingh.quickcart.data.remote.ProductDto
import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val cartDao: CartDao,
    private val apiService: ApiService
) {
    val cartItems: Flow<List<CartItem>> = cartDao.getAllCartItems()

    suspend fun fetchProducts(): Result<List<ProductDto>> {
        return try {
            val response = apiService.getInstantProducts()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun addToCart(item: CartItem) {
        cartDao.insertItem(item)
    }
}
