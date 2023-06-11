package com.splanes.apps.toolboxcompose.theme.typography.default

import androidx.annotation.FontRes
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import com.splanes.apps.toolboxcompose.theme.R.font as RFont

object DefaultFontFamilyTokens {
    val PTSansNarrow: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(RFont.ptsansnarrow_bold, weight = FontWeight.Bold),
            fontOptionLocalOf(RFont.ptsansnarrow_bold, weight = FontWeight.SemiBold),
            fontOptionLocalOf(RFont.ptsansnarrow_bold, weight = FontWeight.Medium),
            fontOptionLocalOf(RFont.ptsansnarrow_regular),
            fontOptionLocalOf(RFont.ptsansnarrow_regular, weight = FontWeight.Light),
            fontOptionLocalOf(RFont.ptsansnarrow_regular, weight = FontWeight.Thin),
        )
    }
    val MonomaniacOne: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(RFont.monomaniac_one_regular, weight = FontWeight.Bold),
            fontOptionLocalOf(RFont.monomaniac_one_regular, weight = FontWeight.SemiBold),
            fontOptionLocalOf(RFont.monomaniac_one_regular, weight = FontWeight.Medium),
            fontOptionLocalOf(RFont.monomaniac_one_regular),
            fontOptionLocalOf(RFont.monomaniac_one_regular, weight = FontWeight.Light),
            fontOptionLocalOf(RFont.monomaniac_one_regular, weight = FontWeight.Thin),
        )
    }
}

private fun fontOptionLocalOf(@FontRes id: Int, weight: FontWeight = FontWeight.Normal) =
    Font(id, weight = weight, loadingStrategy = FontLoadingStrategy.OptionalLocal)
