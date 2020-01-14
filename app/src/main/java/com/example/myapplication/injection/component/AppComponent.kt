package com.example.myapplication.injection.component

import com.example.myapplication.App
import com.example.myapplication.injection.module.AppModule
import com.example.myapplication.injection.module.activity.ActivityBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ActivityBuilder::class, AndroidSupportInjectionModule::class])
 interface AppComponent : AndroidInjector<App?> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App?>


}