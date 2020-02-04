package com.app.changecoin.injection.module.activity

import com.app.changecoin.injection.anotation.PerActivity
import com.app.changecoin.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [ModuleMainActivity::class])
    abstract fun bindMainActivity(): MainActivity?
}