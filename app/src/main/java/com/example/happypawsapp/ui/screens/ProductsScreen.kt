package com.example.happypawsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.happypawsapp.R

// 🔹 Product Model
data class Product(
    val name: String,
    val description: String,
    val price: String,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(navController: NavHostController) {
    val products = listOf(
        Product(
            "Josera Dog Lamb and Batate",
            "Pure lamb pleasure for active nature lovers: lean, grain-free recipe with sweet potatoes.",
            "$25.99",
            R.drawable.josera_lamband_batate
        ),
        Product(
            "Josera Balance",
            "Complete dog food for adults with lower calorie requirements.",
            "$19.99",
            R.drawable.josera_balance
        ),
        Product(
            "Josera Catelux",
            "Ideal food for cats with a tendency to develop hairballs.",
            "$12.50",
            R.drawable.josera_catelux
        ),
        Product(
            "Trixie Premio Chicken Pizza",
            "Premium snack with high-quality ingredients and great taste.",
            "$9.99",
            R.drawable.trixxie_pizza
        ),
        Product(
            "JosiCat Beef in Jelly 400g",
            "Delicious beef-based jelly for adult cats.",
            "$45.00",
            R.drawable.josi_cat_jelly
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Products") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
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
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {

                // 🔹 Category Section (Horizontal Scroll)
                item {
                    Text(
                        text = "Shop by Category ",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        item {
                            CategoryMiniCard(
                                title = "Dog Essentials",
                                onClick = { navController.navigate("dog_products") }
                            )
                        }
                        item {
                            CategoryMiniCard(
                                title = "Cat Essentials",
                                onClick = { navController.navigate("cat_products") }
                            )
                        }
                        item {
                            CategoryMiniCard(
                                title = "Pharmacy ",
                                onClick = { navController.navigate("pharmacy") }
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }

                // 🔹 Top Picks
                item {
                    Text(
                        text = "Top Picks 🛒",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }

                // 🔹 Product List
                items(products) { product ->
                    ProductCard(product = product, onClick = {
                        // Navigate to product detail in future
                        // navController.navigate("product_detail/${product.name}")
                    })
                }
            }
        }
    }
}

// 🔸 Small Horizontal Category Cards
@Composable
fun CategoryMiniCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(100.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

// 🔸 Product Card Design
@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 16.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(product.name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    product.price,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
