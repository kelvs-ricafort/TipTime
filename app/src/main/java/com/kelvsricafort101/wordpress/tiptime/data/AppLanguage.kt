package com.kelvsricafort101.wordpress.tiptime.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kelvsricafort101.wordpress.tiptime.R
import java.util.Locale

enum class AppLanguage(
    val code: String,
    @StringRes val displayName: Int,
    @DrawableRes val flagRes: Int,
    val locale: Locale
) {
    ENGLISH(
        code ="en",
        displayName = R.string.language_english,
        flagRes = R.drawable.flag_english,
        locale = Locale.US
    ),
    FILIPINO(
        code = "fil",
        displayName = R.string.language_filipino,
        flagRes = R.drawable.flag_filipino,
        locale = Locale("fil", "PH")
    ),
    SPANISH(
        code = "es",
        displayName = R.string.language_spanish,
        flagRes = R.drawable.flag_spanish,
        locale = Locale("es", "ES")
    )
}