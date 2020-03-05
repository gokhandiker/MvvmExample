package com.melisa.mvvmexample.util.base

import android.app.Application
import org.koin.core.context.startKoin

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
      //  startKoin(this, listOf(applicationModule))
    }
}