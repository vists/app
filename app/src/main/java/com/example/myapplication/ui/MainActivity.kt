package com.example.myapplication.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.adapterlist.BaseDataBindAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.extension.injectViewModel
import com.example.myapplication.injection.factory.ViewModelFactory
import com.example.myapplication.model.DataPerson
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


open class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModeFactoryProvider: ViewModelFactory

    @Inject
    lateinit var adapterBindPersonData: BaseDataBindAdapter<DataPerson>

    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.apply {
            mainActivityViewModel = injectViewModel(viewModeFactoryProvider)
            adapterDataPerson = adapterBindPersonData
        }
    }
}

