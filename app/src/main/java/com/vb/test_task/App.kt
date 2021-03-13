package com.vb.test_task

import android.app.Application
import com.vb.test_task.di.mainModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules(mainModule) }
    }
}