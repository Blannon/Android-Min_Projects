package com.blannon_network.androidmin_projects.music

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


const val Channel_Id = "channel_id"
const val Channel_Name = "channel_name"
class BaseApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel = NotificationChannel(Channel_Id, Channel_Name,NotificationManager.IMPORTANCE_DEFAULT)

        }
    }
}