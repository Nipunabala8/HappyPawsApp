package com.example.happypawsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.happypawsapp.screens.*
import com.example.happypawsapp.ui.theme.HappyPawsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyPawsAppTheme {
                AppNavigation()
            }
        }
    }
}

// ---------------------- Bottom Navigation Items ----------------------

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

// 🐾 Better icons
val bottomNavItems = listOf(
    BottomNavItem("Home", "login", Icons.Rounded.Home),
    BottomNavItem("Products", "products", Icons.Rounded.Storefront),
    BottomNavItem("Dogs", "dog_products", Icons.Rounded.Pets),
    BottomNavItem("Cats", "cat_products", Icons.Rounded.Face),
    BottomNavItem("Pharmacy", "pharmacy", Icons.Rounded.MedicalServices)
)

// ---------------------- App Navigation ----------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val topLevelRoutes = bottomNavItems.map { it.route }

    Scaffold(
        bottomBar = {
            if (currentRoute in topLevelRoutes) {
                ModernBottomNavBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") { LoginScreen(navController) }
            composable("products") { ProductsScreen(navController) }
            composable("dog_products") { DogProductsScreen(navController) }
            composable("cat_products") { CatProductsScreen(navController) }
            composable("pharmacy") { PharmacyScreen(navController) }
            composable("register") { RegisterScreen(navController) }
        }
    }
}

// ---------------------- Modern Bottom Navigation Bar ----------------------

@Composable
fun ModernBottomNavBar(navController: NavHostController) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    val colorScheme = MaterialTheme.colorScheme

    // Colors automatically adapt to light/dark mode
    val containerColor = colorScheme.surface
    val selectedColor = colorScheme.primary
    val unselectedColor = colorScheme.onSurfaceVariant

    NavigationBar(
        containerColor = containerColor,
        tonalElevation = 8.dp,
        modifier = Modifier
            .shadow(12.dp, RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(containerColor)
    ) {
        bottomNavItems.forEach { item ->
            val selected = currentDestination?.route == item.route
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selected) selectedColor else unselectedColor
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (selected) selectedColor else unselectedColor
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
