package com.example.myapplication.injection.provider

import com.example.myapplication.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitServiceProvider @Inject constructor() {


    private var service: Retrofit.Builder
    private var defaultHttpClient: OkHttpClient


   init {
        val httpBuilder = OkHttpClient.Builder()
        val gson = GsonBuilder()
            .create()
        defaultHttpClient = httpBuilder
            .build()
        service = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(defaultHttpClient)
            .baseUrl(BuildConfig.SERVER_URL)

    }

    fun <T> getServiceRetrofit(clazz: Class<T>): T {
        return service.build().create(clazz)
    }

}