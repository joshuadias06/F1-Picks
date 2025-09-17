package com.terminal.f1picks.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.terminal.f1picks.R
import com.terminal.f1picks.presentation.components.CustomButton
import com.terminal.f1picks.ui.theme.DarkPetrolBlue
import com.terminal.f1picks.ui.theme.F1PicksTheme
import com.terminal.f1picks.ui.theme.White

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onGoogleClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPetrolBlue)
    ) {
        // Background com blur
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(radius = 8.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(160.dp)
                    .padding(top = 32.dp, bottom = 48.dp)
            )

            // Email input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Mail", color = White.copy(alpha = 0.7f)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = White,
                    unfocusedBorderColor = White.copy(alpha = 0.4f),
                    cursorColor = White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // Password input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Password", color = White.copy(alpha = 0.7f)) },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = White,
                    unfocusedBorderColor = White.copy(alpha = 0.4f),
                    cursorColor = White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão principal (Custom)
            CustomButton(
                text = "Login",
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // OR separator
            Text(
                "OR",
                color = White.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ImageButton Google
            Image(
                painter = painterResource(id = R.drawable.icon_google),
                contentDescription = "Google Login",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onGoogleClick() }
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Registro de forma clean
            TextButton(onClick = onRegisterClick) {
                Text(
                    text = "Don't have an account? Register",
                    color = White.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Forgot Password
            TextButton(onClick = onForgotPasswordClick) {
                Text(
                    "Forgot Password?",
                    color = White.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    F1PicksTheme {
        LoginScreen(
            onLoginClick = {},
            onRegisterClick = {},
            onForgotPasswordClick = {},
            onGoogleClick = {}
        )
    }
}
