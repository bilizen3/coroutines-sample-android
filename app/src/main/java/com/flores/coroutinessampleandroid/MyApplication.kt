package com.flores.coroutinessampleandroid

import android.app.Application
import com.flores.coroutinessampleandroid.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * MyApplication
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 05/11/2019
 */

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }

}