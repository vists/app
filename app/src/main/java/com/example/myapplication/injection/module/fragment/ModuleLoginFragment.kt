package com.example.myapplication.injection.module.fragment

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.adapterlist.BaseDataBindAdapter
import com.example.myapplication.api.DataPersonApi
import com.example.myapplication.injection.anotation.ViewModelKey
import com.example.myapplication.injection.factory.ViewModelFactory
import com.example.myapplication.injection.provider.RetrofitServiceProvider
import com.example.myapplication.model.DataPerson
import com.example.myapplication.viewmodel.activity.MainActivityViewModel
import com.example.myapplication.viewmodel.fragment.LoginFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class ModuleLoginFragment {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(LoginFragmentViewModel::class)
    internal abstract fun bindViewModel(viewViewModel: LoginFragmentViewModel): ViewModel


    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideRequestDataPerson(retrofitServiceProvider: RetrofitServiceProvider) =
           retrofitServiceProvider.getServiceRetrofit(DataPersonApi::class.java)

        @JvmStatic
        @Provides
        fun provideAdapterDataPerson(viewViewModel: LoginFragmentViewModel):BaseDataBindAdapter<DataPerson> =
            BaseDataBindAdapter(
                R.layout.item_data,
                BR.dataPerson,
                viewModel = viewViewModel
            )
    }

}
