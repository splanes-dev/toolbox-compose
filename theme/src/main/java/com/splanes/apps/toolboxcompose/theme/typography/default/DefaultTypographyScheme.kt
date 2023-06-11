package com.splanes.apps.toolboxcompose.theme.typography.default

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontWeight
import com.splanes.apps.toolboxcompose.theme.typography.TypographyParamsTokens
import com.splanes.apps.toolboxcompose.theme.typography.toTextStyle

val DefaultTypographyScheme: Typography by lazy {
    Typography(
        displayLarge = TypographyParamsTokens.DisplayLarge.toTextStyle(
            family = DefaultFontFamilyTokens.MonomaniacOne,
            weight = FontWeight.Light,
        ),
        displayMedium = TypographyParamsTokens.DisplayMedium.toTextStyle(
            family = DefaultFontFamilyTokens.MonomaniacOne,
            weight = FontWeight.Light,
        ),
        displaySmall = TypographyParamsTokens.DisplaySmall.toTextStyle(
            family = DefaultFontFamilyTokens.MonomaniacOne,
        ),
        headlineLarge = TypographyParamsTokens.HeadlineLarge.toTextStyle(
            family = DefaultFontFamilyTokens.MonomaniacOne,
        ),
        headlineMedium = TypographyParamsTokens.HeadlineMedium.toTextStyle(
            family = DefaultFontFamilyTokens.MonomaniacOne,
        ),
        headlineSmall = TypographyParamsTokens.HeadlineSmall.toTextStyle(
            family = DefaultFontFamilyTokens.MonomaniacOne,
        ),
        titleLarge = TypographyParamsTokens.TitleLarge.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        titleMedium = TypographyParamsTokens.TitleMedium.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        titleSmall = TypographyParamsTokens.TitleSmall.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        bodyLarge = TypographyParamsTokens.BodyLarge.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        bodyMedium = TypographyParamsTokens.BodyMedium.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        bodySmall = TypographyParamsTokens.BodySmall.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        labelLarge = TypographyParamsTokens.LabelLarge.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        labelMedium = TypographyParamsTokens.LabelMedium.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
        labelSmall = TypographyParamsTokens.LabelSmall.toTextStyle(
            family = DefaultFontFamilyTokens.PTSansNarrow,
        ),
    )
}
