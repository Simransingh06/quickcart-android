package com.simransingh.quickcart.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simransingh.quickcart.data.CartRepository
import com.simransingh.quickcart.data.local.CartItem
import com.simransingh.quickcart.data.remote.ProductDto
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

sealed interface CartUiState {
    object Loading : CartUiState
    data class Success(val products: List<ProductDto>, val cartItems: List<CartItem>) : CartUiState
    data class Error(val message: String) : CartUiState
}

class CartViewModel(private val repository: CartRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<CartUiState>(CartUiState.Loading)
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()

    fun loadCatalog() {
        viewModelScope.launch {
            _uiState.value = CartUiState.Loading
            repository.fetchProducts()
                .onSuccess { products ->
                    repository.cartItems.collect { cartItems ->
                        _uiState.value = CartUiState.Success(products, cartItems)
                    }
                }
                .onFailure {
                    _uiState.value = CartUiState.Error("Failed to fetch product catalog")
                }
        }
    }

    fun addItemToCart(product: ProductDto) {
        viewModelScope.launch {
            repository.addToCart(CartItem(name = product.title, price = product.price, quantity = 1))
        }
    }
}
