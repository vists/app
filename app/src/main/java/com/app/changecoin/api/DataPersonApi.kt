package com.app.changecoin.api

import com.app.changecoin.model.DataPerson
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface DataPersonApi {
        @GET("orgs")
        fun getDataPerson(): Deferred<List<DataPerson>>
}