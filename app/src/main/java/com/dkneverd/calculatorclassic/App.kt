package com.dkneverd.calculatorclassic

import android.app.Application
import com.dkneverd.calculatorclassic.di.dispatcherModule
import com.dkneverd.calculatorclassic.di.networkModule
import com.dkneverd.calculatorclassic.di.repositoryModule
import com.dkneverd.calculatorclassic.di.useCaseModule
import com.dkneverd.calculatorclassic.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                repositoryModule,
                useCaseModule,
                viewModelModule,
                networkModule,
                dispatcherModule
            )
        }
    }
}