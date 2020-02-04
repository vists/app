package com.app.changecoin.injection.provider

import com.app.changecoin.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RetrofitServiceProvider @Inject constructor() {


    private val service: Retrofit.Builder by lazy {
        val httpBuilder = OkHttpClient.Builder()
        val gson = GsonBuilder()
            .create()
        val defaultHttpClient = httpBuilder
            .build()
         Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(defaultHttpClient)
            .baseUrl(BuildConfig.SERVER_URL)
    }

    fun <T> getServiceRetrofit(clazz: Class<T>): T {
        return service.build().create(clazz)
    }

}