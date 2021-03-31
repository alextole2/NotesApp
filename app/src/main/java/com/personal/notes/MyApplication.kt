package com.personal.notes

import android.app.Application
import com.personal.notes.di.DependencyModules
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, DependencyModules.list)
    }
}