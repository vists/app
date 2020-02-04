package com.example.myapplication.injection.module.activity

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.adapterlist.BaseDataBindAdapter
import com.example.myapplication.api.DataPersonApi
import com.example.myapplication.injection.anotation.PerFragment
import com.example.myapplication.injection.anotation.ViewModelKey
import com.example.myapplication.injection.factory.ViewModelFactory
import com.example.myapplication.injection.module.fragment.ModuleLoginFragment
import com.example.myapplication.injection.provider.RetrofitServiceProvider
import com.example.myapplication.model.DataPerson
import com.example.myapplication.ui.fragment.login.LoginFragment
import com.example.myapplication.viewmodel.activity.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

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

//        @JvmStatic
//        @Provides
//        fun provideCoroutineScopeMainJob(@MainScheduler main: MainCoroutineDispatcher, @JobScheduler job:CompletableJob) =
//            CoroutineScope(main+job)

    }


    //Fragment init data

    @PerFragment
    @ContributesAndroidInjector(modules = [ModuleLoginFragment::class])
    internal abstract fun contributeLoginFragment(): LoginFragment

}
