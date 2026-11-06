package com.simransingh.quickcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.simransingh.quickcart.ui.CartUiState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CatalogScreen(state = CartUiState.Loading)
                }
            }
        }
    }
}

@Composable
fun CatalogScreen(state: CartUiState) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "QuickCart Instant Catalog", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        when (state) {
            is CartUiState.Loading -> CircularProgressIndicator()
            is CartUiState.Error -> Text(text = state.message, color = MaterialTheme.colorScheme.error)
            is CartUiState.Success -> {
                LazyColumn {
                    items(state.products) { product ->
                        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                            Row(modifier = Modifier.padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(text = product.title)
                                Text(text = "₹${product.price}")
                            }
                        }
                    }
                }
            }
        }
    }
}
