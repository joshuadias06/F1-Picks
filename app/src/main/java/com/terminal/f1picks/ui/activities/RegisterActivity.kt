package com.terminal.f1picks.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.terminal.f1picks.ui.screens.register.RegisterScreen
import com.terminal.f1picks.ui.theme.F1PicksTheme


class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1PicksTheme {
                RegisterScreen()
            }
        }
    }
}