package com.example.myapplication.api

import com.example.myapplication.model.DataPerson
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface DataPersonApi {
        @GET("orgs")
        fun getDataPerson(): Deferred<List<DataPerson>>
}