package com.app.changecoin.injection.provider

import com.app.changecoin.api.DataPersonApi
import javax.inject.Inject



class DataPersonProvider @Inject constructor(private val retrofitServicePersonData: DataPersonApi){
    fun getDataPersonList() = retrofitServicePersonData.getDataPerson()
}