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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.terminal.f1picks.ui.theme.F1FontFamily
import com.terminal.f1picks.ui.theme.F1PicksTheme
import com.terminal.f1picks.ui.theme.White

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.horizontalGradient(
        colorStops = arrayOf(
            0.0f to Color(0xFF990022),
            0.5f to Color(0xFFFF003C),
            1.0f to Color(0xFF990022)
        )
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .padding(horizontal = 32.dp)
            .fillMaxWidth()
            .background(brush = gradient, shape = RoundedCornerShape(25.dp))
    ) {
        Text(
            fontSize = 26.sp,
            fontFamily = F1FontFamily,
            fontWeight = FontWeight.Normal,
            text = text,
            color = White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    F1PicksTheme {
        CustomButton(
            text = "Começar",
            onClick = {}
        )
    }
}
