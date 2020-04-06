package com.cardona.leagueteamsapp

import android.app.Application
import com.cardona.leagueteamsapp.di.AppComponent
import com.cardona.leagueteamsapp.di.DaggerAppComponent
import com.cardona.leagueteamsapp.di.modules.AppModule

class BaseApp: Application() {

    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()

    }

    fun getComponent() = component

}