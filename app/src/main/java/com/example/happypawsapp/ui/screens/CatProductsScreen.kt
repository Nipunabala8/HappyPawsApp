package com.example.happypawsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CatProductsScreen() {
    val catProducts = listOf("Cat Food", "Cat Toy", "Scratching Post", "Cat Litter", "Cat Collar")

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("🐱 Cat Products", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(catProducts) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(product, style = MaterialTheme.typography.titleMedium)
                            Text("Your cat will love this!", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}


