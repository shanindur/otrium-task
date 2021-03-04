package com.shanindu.github.app

import android.app.Application
import com.shanindu.github.app.di.component.ApplicationComponent
import com.shanindu.github.app.di.component.DaggerApplicationComponent
import com.shanindu.github.app.di.module.ApplicationModule

/**
 * Created by Shanindu on 03/03/2021.
 */
class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }
}