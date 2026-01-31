package com.deyvieat.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.deyvieat.store.presentation.screens.HomeScreen
import com.deyvieat.store.presentation.screens.HomeViewModel
import com.deyvieat.store.ui.theme.StoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)

                    HomeScreen(
                        uiState = viewModel.uiState,
                        cartItems = viewModel.cartItems,
                        onAddToCart = viewModel::addToCart,
                        retryAction = viewModel::getProducts
                    )
                }
            }
        }
    }
}