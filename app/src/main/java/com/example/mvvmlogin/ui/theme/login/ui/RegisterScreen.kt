package com.example.mvvmlogin.ui.theme.login.ui

import RegisterButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.mvvmlogin.R
import com.example.mvvmlogin.ui.theme.login.model.Connection


@Composable
fun RegisterScreen() {
    var email by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            HeaderImage()
            RegistrationForm(email, username, password) { newEmail, newUsername, newPassword ->
                email = newEmail
                username = newUsername
                password = newPassword
            }
            RegisterButton2(onClick = { /* Implementa la lógica de registro aquí */ })
        }
    }
}

@Composable
fun RegistrationForm(email: String, username: String, password: String, onValueChanged: (String, String, String) -> Unit) {
    EmailInput(email) { newEmail -> onValueChanged(newEmail, username, password) }
    Spacer(modifier = Modifier.padding(5.dp)) // Añadido espacio entre los campos
    UsernameInput(username) { newUsername -> onValueChanged(email, newUsername, password) }
    PasswordField(password) { newPassword -> onValueChanged(email, username, newPassword) }
    Spacer(modifier = Modifier.padding(5.dp)) // Añadido espacio entre los campos
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInput(email: String, onValueChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onValueChanged(it) },
        label = { Text("Correo Electrónico") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp) // Reducido el espacio vertical
            .padding(top = 10.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsernameInput(username: String, onValueChanged: (String) -> Unit) {
    TextField(
        value = username,
        onValueChange = { onValueChanged(it) },
        label = { Text("Usuario") },
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp) // Reducido el espacio vertical
            .padding(bottom = 8.dp), // Ajustado el espacio inferior
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

// Resto del código sin cambios


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onPasswordChange: (String) -> Unit) {
    TextField(
        value = password,
        onValueChange = { onPasswordChange(it) },
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
fun RegisterButton2(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF1000FF))
    ) {
        Text("Registrarse")
    }
}

@Composable
fun HeaderImage() {
    // Imagen del encabezado
    Image(
        painter = painterResource(id = R.drawable.nexahomelogo),
        contentDescription = "Header",
        modifier = Modifier
            .fillMaxWidth()
    )
}

