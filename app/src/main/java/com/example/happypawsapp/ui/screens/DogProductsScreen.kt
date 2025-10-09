package com.example.happypawsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DogProductsScreen() {
    val dogProducts = listOf("Dog Food", "Dog Collar", "Chew Toy", "Dog Bed", "Dog Shampoo")

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("🐶 Dog Products", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(dogProducts) { product ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(product, style = MaterialTheme.typography.titleMedium)
                            Text("Perfect for your furry friend!", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
