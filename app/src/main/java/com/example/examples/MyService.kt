package com.example.examples

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlin.concurrent.thread


class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        thread {
            while (true) {
                println("Service is Running..")
                Thread.sleep(2000L)
            }
        }
    }
}