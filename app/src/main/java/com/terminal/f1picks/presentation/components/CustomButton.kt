package com.terminal.f1picks.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.terminal.f1picks.ui.theme.White

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.linearGradient(
        colorStops = arrayOf(
            0.0f to Color(0xFFFF003C),
            0.7f to Color(0xFFFF003C),
            1.0f to Color(0xFF990022)
        ),
        start = Offset(0f, 0f),
        end = Offset(1000f, 0f)
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .background(brush = gradient, shape = RoundedCornerShape(16.dp))
    ) {
        Text(
            text = text,
            color = White
        )
    }
}
