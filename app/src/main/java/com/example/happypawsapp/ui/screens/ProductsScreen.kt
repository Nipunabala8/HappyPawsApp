package com.example.happypawsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProductsScreen(navController: NavHostController) {
    val products = listOf(
        "Premium Dog Food",
        "Cat Scratching Post",
        "Pet Shampoo",
        "Chew Toys",
        "Pet Bed"
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Top Selling Products 🛍️", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(products) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(product, style = MaterialTheme.typography.titleMedium)
                            Text("Best quality for your pet!", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}

