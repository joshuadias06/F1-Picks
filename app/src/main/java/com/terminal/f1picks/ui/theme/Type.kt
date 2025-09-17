package com.terminal.f1picks.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.terminal.f1picks.R


val F1FontFamily = FontFamily(
    Font(R.font.f1_regular, FontWeight.Normal),
    Font(R.font.f1_bold, FontWeight.Bold),
    Font(R.font.f1_wide, FontWeight.Medium),
    Font(R.font.f1_black, FontWeight.Black),
    Font(R.font.f1_italic, FontWeight.Thin),
    Font(R.font.f1_bold_web, FontWeight.ExtraBold)
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = F1FontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = F1FontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = F1FontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
