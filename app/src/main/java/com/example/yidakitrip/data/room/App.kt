package com.example.yidakitrip.data.room

import android.app.Application

class App: Application() {
    val dataBase by lazy { AppDatabase.createDataBase(this) }
}