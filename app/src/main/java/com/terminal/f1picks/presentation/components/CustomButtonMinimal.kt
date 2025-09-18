package com.terminal.f1picks.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.terminal.f1picks.ui.theme.White

@Composable
fun CustomButtonMinimal(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = White.copy(alpha = 0.1f), // leve transparência para suavizar
            contentColor = White
        ),
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp), // sem sombra
        modifier = modifier
            .fillMaxWidth()
            .height(42.dp) // mais fino
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenMinimalPreview() {
    CustomButtonMinimal(
        text = "Login",
        onClick = {},
        modifier = Modifier
    )
}
