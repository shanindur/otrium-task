package com.shanindu.github.app.di.component

import com.shanindu.github.app.di.module.ActivityModule
import com.shanindu.github.app.ui.main.MainActivity
import dagger.Component

/**
 * Created by Shanindu on 03/03/2021.
 */
@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}