package com.shanindu.github.app.di.component

import com.shanindu.github.app.BaseApp
import com.shanindu.github.app.di.module.ApplicationModule
import dagger.Component

/**
 * Created by Shanindu on 03/03/2021.
 */
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}