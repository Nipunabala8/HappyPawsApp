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

data class PharmacyProduct(
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PharmacyScreen(navController: NavHostController) {
    val pharmacyProducts = listOf(
        PharmacyProduct("Trixie Flea and Tick Shampoo", "Flea and Tick Shampoo suitable for dogs from 12 weeks active", "$14.99", R.drawable.flea_and_tick_shampoo),
        PharmacyProduct("Trixie Ear Care Wipes", "Ear Care Wipes for dogs, cats and other small animals with gentle cleaning lotion for regular care", "$9.99", R.drawable.ear_care_wipes),
        PharmacyProduct("Cat Shampoo for Long Hair", "Cat Shampoo for Long Hair eases combing and prevents matts", "$7.49", R.drawable.cat_shampoo),
        PharmacyProduct("Aluspray ", "Boost your pet’s immunity and vitality.", "$11.99", R.drawable.aluspray)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pharmacy") },
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
                items(pharmacyProducts) { product ->
                    PharmacyProductCard(product.name, product.description, product.price, product.imageRes)
                }
            }
        }
    }
}

@Composable
fun PharmacyProductCard(name: String, description: String, price: String, imageRes: Int) {
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
