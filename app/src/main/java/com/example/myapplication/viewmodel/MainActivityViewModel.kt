package com.example.myapplication.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.example.myapplication.injection.anotation.PerActivity
import com.example.myapplication.injection.provider.DataPersonProvider
import com.example.myapplication.model.DataPerson
import com.example.myapplication.viewmodel.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@PerActivity
class MainActivityViewModel @Inject constructor(
    private val coroutineScopeMainJob: CoroutineScope,
    dataPersonProvider: DataPersonProvider

) : BaseViewModel() {


    init {
        coroutineScopeMainJob.launch {
            dataPersonList = dataPersonProvider.getDataPersonList().await()
        }
    }

    @set:Bindable
    @get:Bindable
    var dataPersonList by bindable(emptyList<DataPerson>(), BR.dataPersonList)

    val countData
        @Bindable("dataPersonList")
        get() = "Total size: ${dataPersonList.size}"

    override fun onCleared() {
        coroutineScopeMainJob.cancel()
        super.onCleared()
    }
}