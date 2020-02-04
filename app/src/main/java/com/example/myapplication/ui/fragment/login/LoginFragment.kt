package com.example.myapplication.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.adapterlist.BaseDataBindAdapter
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.extension.injectViewModel
import com.example.myapplication.injection.factory.ViewModelFactory
import com.example.myapplication.model.DataPerson
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class LoginFragment : DaggerFragment() {

    @Inject
    lateinit var viewModeFactoryProvider: ViewModelFactory

    @Inject
    lateinit var adapterBindPersonData: BaseDataBindAdapter<DataPerson>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false).apply {
            loginFragmentViewModel = injectViewModel(viewModeFactoryProvider)
            adapterDataPerson =  adapterBindPersonData
        }.root
    }
}
