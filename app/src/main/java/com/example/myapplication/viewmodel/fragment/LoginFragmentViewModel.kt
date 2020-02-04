package com.example.myapplication.viewmodel.fragment

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.viewModelScope
import com.example.myapplication.injection.anotation.PerActivity
import com.example.myapplication.injection.anotation.PerFragment
import com.example.myapplication.injection.provider.DataPersonProvider
import com.example.myapplication.model.DataPerson
import com.example.myapplication.viewmodel.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@PerFragment
class LoginFragmentViewModel @Inject constructor(
    dataPersonProvider: DataPersonProvider
) : BaseViewModel() {

    init {
        viewModelScope.launch {
           dataPersonList = dataPersonProvider.getDataPersonList().await()
        }
    }

    @set:Bindable
    @get:Bindable
    var dataPersonList by bindable(emptyList<DataPerson>(), BR.dataPersonList)

    val countData
        @Bindable("dataPersonList")
        get() = "Total size: ${dataPersonList.size}"

}