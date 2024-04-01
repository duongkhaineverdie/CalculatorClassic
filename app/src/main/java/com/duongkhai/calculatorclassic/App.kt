package com.duongkhai.calculatorclassic

import android.app.Application
import com.duongkhai.calculatorclassic.di.dispatcherModule
import com.duongkhai.calculatorclassic.di.networkModule
import com.duongkhai.calculatorclassic.di.repositoryModule
import com.duongkhai.calculatorclassic.di.useCaseModule
import com.duongkhai.calculatorclassic.di.viewModelModule
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