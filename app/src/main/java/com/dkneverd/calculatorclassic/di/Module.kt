package com.dkneverd.calculatorclassic.di

import android.app.Application
import androidx.room.Room
import com.dkneverd.calculatorclassic.BuildConfig
import com.dkneverd.calculatorclassic.domain.interactors.GetIPLocationDetailUseCase
import com.dkneverd.calculatorclassic.domain.interactors.GetRemoteConfigUseCase
import com.dkneverd.calculatorclassic.domain.repository.RepositoryImpl
import com.dkneverd.calculatorclassic.data.repository.IRepository
import com.dkneverd.calculatorclassic.data.repository.RemoteConfigRepo
import com.dkneverd.calculatorclassic.data.repository.RemoteConfigRepoImpl
import com.dkneverd.calculatorclassic.presentation.MainViewModel
import com.dkneverd.calculatorclassic.presentation.ui.home.HomeViewModel
import com.truongvim.snakegame.data.repository.IPLocationApi
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    single { MainViewModel() }
    single { HomeViewModel() }
}

val repositoryModule = module {
    single<com.dkneverd.calculatorclassic.data.repository.RemoteConfigRepo> { com.dkneverd.calculatorclassic.data.repository.RemoteConfigRepoImpl() }
    single<com.dkneverd.calculatorclassic.data.repository.IRepository> { RepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetRemoteConfigUseCase(get(), get()) }
    factory { GetIPLocationDetailUseCase(get(), get()) }
}

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideIPLocationDetail(get()) }
    single { provideRetrofit(get()) }
}

val dispatcherModule = module {
    factory { Dispatchers.Default }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(com.dkneverd.calculatorclassic.BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideIPLocationDetail(retrofit: Retrofit): IPLocationApi =
    retrofit.create(IPLocationApi::class.java)