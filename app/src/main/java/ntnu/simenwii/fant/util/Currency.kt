package ntnu.simenwii.fant.util

import android.icu.number.Notation
import android.icu.number.NumberFormatter
import android.icu.util.Currency
import android.icu.util.ULocale

fun formatNOK(price: Int): String {
    // Custom notation, unit, and rounding strategy:
    return NumberFormatter.with()
        .notation(Notation.compactShort())
        .unit(Currency.getInstance("NOK"))
//        .precision(Precision.integer())
        .locale(ULocale.forLanguageTag("no"))
        .format(price)
        .toString()  // €1.2K in en-US

//    NumberFormatter.withLocale(ULocale.forLanguageTag("NO"))
}