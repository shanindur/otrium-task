package com.shanindu.github.app.di.module

import android.app.Application
import com.shanindu.github.app.BaseApp
import com.shanindu.github.app.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Shanindu on 03/03/2021.
 */
@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}