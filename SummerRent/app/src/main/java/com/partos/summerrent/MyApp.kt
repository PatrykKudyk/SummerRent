package com.partos.summerrent

import android.app.Application
import com.partos.summerrent.models.Date

class MyApp() : Application() {
    companion object {
        val dayOne = Date(1, 1, 2020, 3)
        var focused = Date(0, 0, 0, 0)
        var noteFocused = Date(0, 0, 0, 0)
        var color = -1
        var isEditing = false
    }
}