package com.example.myapplication.extension

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity

inline fun <reified T : ViewModel> DaggerAppCompatActivity.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory)[T::class.java]
}

