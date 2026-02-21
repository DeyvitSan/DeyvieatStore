package com.deyvieat.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.deyvieat.store.core.ui.theme.StoreTheme
import com.deyvieat.store.features.store.presentation.screens.ProductsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoreTheme {
                ProductsScreen()
            }
        }
    }
}