package com.example.examples

interface AlarmScheduler {
    fun schedule(item : AlarmItem)
    fun cancel(item : AlarmItem)
}