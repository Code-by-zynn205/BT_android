package com.example.coffeeapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.coffeeapptheme.R

// Định nghĩa phông chữ
val CoffeeFont = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

// Cấu hình Typography
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = CoffeeFont,
        fontWeight = FontWeight.Normal,

    ),
    bodyMedium = TextStyle(
        fontFamily = CoffeeFont,
        fontWeight = FontWeight.Normal
    ),
    titleLarge = TextStyle(
        fontFamily = CoffeeFont,
        fontWeight = FontWeight.Bold
    )
)
