package com.app.changecoin.injection.module.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.changecoin.injection.anotation.PerFragment
import com.app.changecoin.injection.anotation.ViewModelKey
import com.app.changecoin.injection.factory.ViewModelFactory
import com.app.changecoin.injection.module.fragment.ModuleLoginFragment
import com.app.changecoin.ui.fragment.login.LoginFragment
import com.app.changecoin.viewmodel.activity.MainActivityViewModel
import dagger.Binds
import dagger.Module
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
