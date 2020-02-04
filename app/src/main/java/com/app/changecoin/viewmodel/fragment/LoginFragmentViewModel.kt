package com.app.changecoin.viewmodel.fragment

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.viewModelScope
import com.app.changecoin.injection.anotation.PerFragment
import com.app.changecoin.injection.provider.DataPersonProvider
import com.app.changecoin.model.DataPerson
import com.app.changecoin.viewmodel.base.BaseViewModel
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