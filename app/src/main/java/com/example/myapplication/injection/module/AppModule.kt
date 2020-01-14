package com.example.myapplication.injection.module

import android.content.Context
import com.example.myapplication.injection.anotation.JobScheduler
import com.example.myapplication.injection.anotation.MainScheduler
import com.example.myapplication.injection.provider.RetrofitServiceProvider
import com.example.myapplication.injection.provider.SharedPreferenceProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @JobScheduler
    fun provideJobScheduler() = Job()

    @Provides
    @MainScheduler
    fun provideMainScheduler() = Dispatchers.Main

    @Singleton
    @Provides
    fun provideRetrofit():RetrofitServiceProvider = RetrofitServiceProvider()

    @Singleton
    @Provides
    fun provideSharedPreference(contextApp: Context): SharedPreferenceProvider =
        SharedPreferenceProvider(contextApp)

}
