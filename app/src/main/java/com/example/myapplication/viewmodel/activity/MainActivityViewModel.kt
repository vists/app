package com.example.myapplication.viewmodel.activity

import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.viewModelScope
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

) : BaseViewModel()