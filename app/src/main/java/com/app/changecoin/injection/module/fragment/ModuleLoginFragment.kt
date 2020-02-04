package com.app.changecoin.injection.module.fragment

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.changecoin.R
import com.app.changecoin.adapterlist.BaseDataBindAdapter
import com.app.changecoin.api.DataPersonApi
import com.app.changecoin.injection.anotation.ViewModelKey
import com.app.changecoin.injection.factory.ViewModelFactory
import com.app.changecoin.injection.provider.RetrofitServiceProvider
import com.app.changecoin.model.DataPerson
import com.app.changecoin.viewmodel.fragment.LoginFragmentViewModel
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
