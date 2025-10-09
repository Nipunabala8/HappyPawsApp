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

data class CatProduct(
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatProductsScreen(navController: NavHostController) {
    val catProducts = listOf(
        CatProduct(
            "Josera Nature Cat",
            "NatureCat is a true pleasure for all adventurers. Grain-free and with an extra serving of delicious poultry and salmon",
            "$12.50",
            R.drawable.josera_nature
        ),
        CatProduct(
            "Josi Cat Crispy Duck",
            "JosiCat Crispy Duck Cat food will satisfy even the most discerning kitties!",
            "$15.00",
            R.drawable.josi_cat_crispy_duck
        ),
        CatProduct(
            "JosiCat Salmon in Sauce 415g",
            "JosiCat Fish in Sauce is the nautical pet treat for adult cats. Here tasty pieces in sauce are served with delicious pollock.",
            "$5.99",
            R.drawable.josicat_fish
        ),
        CatProduct(
            "JosiCat Kitten",
            "JosiCat Kitten is a balanced menu for adventurous young cats.",
            "$10.99",
            R.drawable.josicatkitten
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cat Products") },
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
                items(catProducts) { product ->
                    ProductCard(
                        name = product.name,
                        description = product.description,
                        price = product.price,
                        imageRes = product.imageRes
                    )
                }
            }
        }
    }
}

@Composable
fun ProductCard(name: String, description: String, price: String, imageRes: Int) {
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
