package com.deyvieat.store.presentation.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.deyvieat.store.domain.entity.Product
import com.deyvieat.store.domain.repository.ProductRepository
import com.deyvieat.store.presentation.StoreApp
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val products: List<Product>) : HomeUiState
    object Error : HomeUiState
}

class HomeViewModel(private val productRepository: ProductRepository) : ViewModel() {

    var uiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    private val _cartItems = mutableStateListOf<Product>()
    val cartItems: List<Product> get() = _cartItems

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            uiState = HomeUiState.Loading
            uiState = try {
                val list = productRepository.getProducts()
                HomeUiState.Success(list)
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: Exception) {
                HomeUiState.Error
            }
        }
    }

    fun addToCart(product: Product) {
        _cartItems.add(product)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as StoreApp)
                val repository = application.container.productRepository
                HomeViewModel(repository)
            }
        }
    }
}