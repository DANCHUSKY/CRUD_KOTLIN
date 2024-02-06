// LoginScreen.kt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

import com.example.mvvmlogin.R
import com.example.mvvmlogin.ui.theme.login.model.Connection

@Composable
fun LoginScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Login(Modifier.align(Alignment.Center), navController)
    }
}

@Composable
fun Login(modifier: Modifier, navController: NavHostController) {

    //Esto es para obtener la instancia
    //var pepe:Connection = Connection.getInstance()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }

    Column(modifier = modifier) {
        HeaderImage()
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(email = email, onEmailChange = { email = it })
        Spacer(modifier = Modifier.padding(4.dp))
        PasswordField(password = password, onPasswordChange = { password = it })
        Spacer(modifier = Modifier.padding(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.padding(16.dp))
        LoginButton(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    // Lógica de inicio de sesión
                    showErrorDialog = false
                } else {
                    // Campos vacíos, mostrar alerta
                    showErrorDialog = true
                }
            },

        )
        Spacer(modifier = Modifier.padding(8.dp))
        RegisterButton(onClick = { navController.navigate("register") });
        {

        }

    }

    if (showErrorDialog) {
        // Mostrar la alerta con estilo personalizado
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            title = {},
            text = {
                Text(
                    "Por favor, completa todos los campos.",
                    color = Color.Black,
                    fontSize = 16.sp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = { showErrorDialog = false }
                ) {
                    Text("OK", color = Color.Blue)
                }
            },
        )
    }
}

@Composable
fun RegisterButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF1000FF))
    ) {
        Text(text = "Registrarse")
    }
}


// Resto del código para ForgotPassword, PasswordField, EmailField y HeaderImage

@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF1000FF))
    ) {
        Text(text = "Iniciar Sesión")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "¿Olvidaste la Contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFFF5600)
    )
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onEmailChange: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onEmailChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
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
fun HeaderImage() {
    Image(painter = painterResource(id = R.drawable.nexahomelogo), contentDescription = "Header")
}
