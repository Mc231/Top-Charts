package com.vshyrochuk.topcharts.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.vshyrochuk.topcharts.R

val SfProDisplay = FontFamily(
    Font(R.font.sfprodisplay_bold, weight = FontWeight.Bold),
    Font(R.font.sfprodisplay_regular, weight = FontWeight.Normal),
    Font(R.font.sfprodisplay_semibold, weight = FontWeight.SemiBold),
    Font(R.font.sfprodisplay_medium, weight = FontWeight.Medium),
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        color = Black,
        textAlign = TextAlign.Left,
    ),
    subtitle1 = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Black,
        textAlign = TextAlign.Left,
    ),
    body1 = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = White,
        textAlign = TextAlign.Left
    ),
    body2 = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = SecondaryGray,
        textAlign = TextAlign.Left
    ),
    caption = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = PrimaryGray,
        textAlign = TextAlign.Center
    ),
    button = TextStyle(
        fontFamily = SfProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = White
    ),
)