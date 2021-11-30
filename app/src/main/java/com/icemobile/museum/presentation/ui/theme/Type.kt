package com.icemobile.museum.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.icemobile.museum.R

val MuseumBible = FontFamily(
    Font(R.font.museum_bible)
)

val MuseumFoundry = FontFamily(
    Font(R.font.museum_foundry)
)

val MuseumFourteen = FontFamily(
    Font(R.font.museum_fourteen)
)

val MuseumSixty = FontFamily(
    Font(R.font.museum_sixty)
)


// Set of Material typography styles to start with
val Typography = Typography(

    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        fontFamily = MuseumBible
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        fontFamily = MuseumBible
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        fontFamily = MuseumBible
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        fontFamily = MuseumBible
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        fontFamily = MuseumBible
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 8.sp,
        fontFamily = MuseumBible
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = MuseumSixty,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = MuseumSixty,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    )
)