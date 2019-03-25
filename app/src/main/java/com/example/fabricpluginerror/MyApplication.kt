package com.example.fabricpluginerror

import android.app.Application
import com.example.FabricInit

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FabricInit.initFabric(this)
    }
}