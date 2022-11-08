package com.samm.cryptoapp.presentation.crypto_details_screen.util

import java.math.RoundingMode
import java.text.DecimalFormat

object Converters {
    fun roundOffDecimal(number: Double): Double {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        return df.format(number).toDouble()
    }
}