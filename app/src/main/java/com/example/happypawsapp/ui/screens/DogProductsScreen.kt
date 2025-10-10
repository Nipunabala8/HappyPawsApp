package com.example.happypawsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.happypawsapp.R

data class DogProduct(
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogProductsScreen(navController: NavHostController) {
    val dogProducts = listOf(
        DogProduct("Josera Mini Deluxe", "osera Mini Deluxe comes Without grains but full of vegetables, herbs and fruits along with a large portion of lamb", "$20.00", R.drawable.josera_mini_deluxe),
        DogProduct("Josi Dog Active", "JosiDog Active is an energy packed dog food for adult active dogs", "$8.99", R.drawable.josi_dog_active),
        DogProduct("Josidog Junior Sensitive", "Sensitive dogs from age eight weeks can enjoy real homestyle petfood with JosiDog Junior Sensitive!", "$25.50", R.drawable.josi_sentive),
        DogProduct("Bavaro Junior", "Food for adult working and sports dogs of all breeds. Also perfect for puppies from the age of 2 months.", "$9.75", R.drawable.bavaro_junior)

    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dog Products") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(dogProducts) { product ->
                    DogProductCard(product.name, product.description, product.price, product.imageRes)
                }
            }
        }
    }
}

@Composable
fun DogProductCard(name: String, description: String, price: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(description, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(price, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

