package com.partos.summerrent

import android.app.Application
import com.partos.summerrent.models.Date

class MyApp() : Application() {
    companion object {
        val dayOne = Date(1, 6, 2020, 1)
    }
}