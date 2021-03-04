package com.shanindu.github.app.di.module

import android.app.Activity
import com.shanindu.github.app.ui.main.MainContract
import com.shanindu.github.app.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Shanindu on 03/03/2021.
 */
@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}