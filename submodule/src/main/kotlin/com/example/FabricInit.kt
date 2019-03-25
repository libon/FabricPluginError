package com.example

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import com.example.submodule.BuildConfig
import io.fabric.sdk.android.Fabric

object FabricInit {
    fun initFabric(application: Application) {
        val core = CrashlyticsCore.Builder().delay(1F).build()
        val crashlytics = Crashlytics.Builder()
            .core(core)
            .build()

        val fabric = Fabric.Builder(application)
            .kits(crashlytics)
            .debuggable(BuildConfig.DEBUG).build()
        Fabric.with(fabric)
    }
}