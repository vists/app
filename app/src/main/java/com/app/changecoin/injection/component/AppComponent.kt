package com.app.changecoin.injection.component

import com.app.changecoin.App
import com.app.changecoin.injection.module.AppModule
import com.app.changecoin.injection.module.activity.ActivityBuilder
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