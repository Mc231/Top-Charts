package com.vshyrochuk.topcharts.screens.chartpreview

import java.text.SimpleDateFormat
import java.util.Locale

object ReleaseDateFormatter {

    fun format(
        releaseDate: String,
        inputFormat: String = "yyyy-MM-dd",
        outputFormat: String = "MMM d, yyyy",
        locale: Locale = Locale.US
    ): String {
        val inputFormatter = SimpleDateFormat(inputFormat, locale)
        try {
            val inputDate = inputFormatter.parse(releaseDate)
            val outputFormatter = SimpleDateFormat(outputFormat, locale)
            if (inputDate != null) {
                return outputFormatter.format(inputDate)
            }
            return releaseDate
        } catch (e: Exception) {
            e.printStackTrace()
            return releaseDate
        }
    }
}
