package com.example.luckyjack

import android.app.Application

class MainApplication : Application() {
    lateinit var fileDATA : FileData

    override fun onCreate() {
        super.onCreate()

        fileDATA = FileData("jack_data", this)
    }
}