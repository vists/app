package com.example.myapplication.injection.module.activity

import com.example.myapplication.injection.anotation.PerActivity
import com.example.myapplication.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [ModuleMainActivity::class])
    abstract fun bindMainActivity(): MainActivity?
}