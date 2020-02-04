package com.app.changecoin

import com.app.changecoin.injection.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


open class App  : DaggerApplication() {

    var z:HashMap<String,Any> = hashMapOf()

    override fun onCreate() {
        super.onCreate()

        if (!BuildConfig.DEBUG) {
        }
    }

    override fun applicationInjector(): AndroidInjector<out App?> = DaggerAppComponent.factory()
        .create(this)

}