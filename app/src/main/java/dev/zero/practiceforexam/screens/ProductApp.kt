package dev.zero.practiceforexam.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import dev.zero.practiceforexam.api.RetrofitInstance
import dev.zero.practiceforexam.model.Product

@Composable
fun ProductApp() {
    val scaffoldState = rememberScaffoldState()
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var selectedProduct by remember { mutableStateOf<Product?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        try {
            products = RetrofitInstance.api.getProducts()
        } catch (e: Exception) {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Lỗi tải dữ liệu")
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(products) { prod ->
                ProductItem(
                    product = prod,
                    onClick = { selectedProduct = prod }
                )
            }
        }

        // Hiển thị Dialog khi có product được chọn
        selectedProduct?.let { prod ->
            ProductDetailDialog(
                product = prod,
                onDismiss = { selectedProduct = null }
            )
        }
    }
}
