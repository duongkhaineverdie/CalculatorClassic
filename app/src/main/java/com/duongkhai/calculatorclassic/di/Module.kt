package com.duongkhai.calculatorclassic.di

import android.app.Application
import androidx.room.Room
import com.duongkhai.calculatorclassic.BuildConfig
import com.duongkhai.calculatorclassic.domain.interactors.GetIPLocationDetailUseCase
import com.duongkhai.calculatorclassic.domain.interactors.GetRemoteConfigUseCase
import com.duongkhai.calculatorclassic.domain.repository.RepositoryImpl
import com.duongkhai.calculatorclassic.data.repository.IRepository
import com.duongkhai.calculatorclassic.data.repository.RemoteConfigRepo
import com.duongkhai.calculatorclassic.data.repository.RemoteConfigRepoImpl
import com.duongkhai.calculatorclassic.presentation.MainViewModel
import com.duongkhai.calculatorclassic.presentation.ui.home.HomeViewModel
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
    single<RemoteConfigRepo> { RemoteConfigRepoImpl() }
    single<IRepository> { RepositoryImpl(get(), get()) }
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
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideIPLocationDetail(retrofit: Retrofit): IPLocationApi =
    retrofit.create(IPLocationApi::class.java)