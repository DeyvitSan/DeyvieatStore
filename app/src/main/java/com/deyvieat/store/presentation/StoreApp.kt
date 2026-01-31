package com.deyvieat.store.presentation

import android.app.Application
import com.deyvieat.store.di.AppContainer

class StoreApp : Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer()
    }
}