package com.example.myapplication.injection.module.activity

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.adapterlist.BaseDataBindAdapter
import com.example.myapplication.api.DataPersonApi
import com.example.myapplication.injection.anotation.JobScheduler
import com.example.myapplication.injection.anotation.MainScheduler
import com.example.myapplication.injection.anotation.ViewModelKey
import com.example.myapplication.injection.factory.ViewModelFactory
import com.example.myapplication.injection.provider.RetrofitServiceProvider
import com.example.myapplication.model.DataPerson
import com.example.myapplication.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.*

@Module
abstract class ModuleMainActivity {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindViewModel(viewViewModel: MainActivityViewModel): ViewModel


    @Module
    companion object {
               @JvmStatic
        @Provides
        fun provideAdapterDataPerson(viewViewModel: MainActivityViewModel) =
            BaseDataBindAdapter<DataPerson>(
                R.layout.item_data,
                BR.dataPerson,
                viewModel = viewViewModel
            )

//        @JvmStatic
//        @Provides
//        fun provideCoroutineScopeMainJob(@MainScheduler main: MainCoroutineDispatcher, @JobScheduler job:CompletableJob) =
//            CoroutineScope(main+job)

        @JvmStatic
        @Provides
        fun provideRequestDataPerson(retrofitServiceProvider: RetrofitServiceProvider) =
           retrofitServiceProvider.getServiceRetrofit(DataPersonApi::class.java)

    }

}
