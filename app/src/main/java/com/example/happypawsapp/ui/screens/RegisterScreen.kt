package com.example.happypawsapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun RegisterScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Create Account", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(value = name, onValueChange = { name = it },
                label = { Text("Full Name") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(value = email, onValueChange = { email = it },
                label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(value = password, onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) { Text("Register") }
            Spacer(modifier = Modifier.height(12.dp))
            TextButton(onClick = { navController.navigate("login") }) {
                Text("Already have an account? Login")
            }
        }
    }
}
