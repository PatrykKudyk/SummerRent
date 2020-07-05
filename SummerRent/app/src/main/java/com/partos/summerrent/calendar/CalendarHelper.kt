package com.partos.summerrent.calendar

import android.content.Context
import com.partos.summerrent.db.DataBaseHelper
import com.partos.summerrent.models.Day
import java.util.*
import kotlin.collections.ArrayList

class CalendarHelper(val context: Context) {
    fun getSmallMonthsList(all: Boolean): ArrayList<ArrayList<Day>> {
        val db = DataBaseHelper(context)
        var monthsList = ArrayList<ArrayList<Day>>()
        if (all) {
            for (year in 2020..2025) {
                for (month in 1..12) {
                    monthsList.add(db.getSmallMonth(month, year))
                }
            }
        } else {
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            if (currentYear < 2024) {
                for (year in currentYear..(currentYear + 2)) {
                    for (month in 1..12) {
                        monthsList.add(db.getSmallMonth(month, year))
                    }
                }
            } else {
                for (year in 2024..2025) {
                    for (month in 1..12) {
                        monthsList.add(db.getSmallMonth(month, year))
                    }
                }
            }
        }
        return monthsList
    }

    fun getBigMonthsList(all: Boolean): ArrayList<ArrayList<Day>> {
        val db = DataBaseHelper(context)
        var monthsList = ArrayList<ArrayList<Day>>()
        if (all) {
            for (year in 2020..2025) {
                for (month in 1..12) {
                    monthsList.add(db.getBigMonth(month, year))
                }
            }
        } else {
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            if (currentYear < 2024) {
                for (year in currentYear..(currentYear + 2)) {
                    for (month in 1..12) {
                        monthsList.add(db.getBigMonth(month, year))
                    }
                }
            } else {
                for (year in 2024..2025) {
                    for (month in 1..12) {
                        monthsList.add(db.getBigMonth(month, year))
                    }
                }
            }
        }
        return monthsList
    }
}