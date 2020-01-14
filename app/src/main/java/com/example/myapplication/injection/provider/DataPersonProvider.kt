package com.example.myapplication.injection.provider

import com.example.myapplication.api.DataPersonApi
import javax.inject.Inject



class DataPersonProvider @Inject constructor(private val retrofitServicePersonData: DataPersonApi){
    fun getDataPersonList() = retrofitServicePersonData.getDataPerson()
}