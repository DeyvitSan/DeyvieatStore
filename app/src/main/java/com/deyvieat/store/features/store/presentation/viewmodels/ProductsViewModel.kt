package com.deyvieat.store.features.store.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deyvieat.store.features.store.domain.usecases.GetProductsUseCase
import com.deyvieat.store.features.store.presentation.screens.ProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadProducts()
    }

    fun loadProducts() {
        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = getProductsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, products = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}
