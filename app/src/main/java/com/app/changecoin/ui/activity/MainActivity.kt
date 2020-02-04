package com.app.changecoin.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.changecoin.R
import com.app.changecoin.databinding.ActivityMainBinding
import com.app.changecoin.extension.injectViewModel
import com.app.changecoin.injection.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


open class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModeFactoryProvider: ViewModelFactory

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.apply {
            mainActivityViewModel = injectViewModel(viewModeFactoryProvider)
        }
    }
}

