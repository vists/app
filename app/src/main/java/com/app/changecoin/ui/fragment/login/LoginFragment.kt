package com.app.changecoin.ui.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.app.changecoin.R
import com.app.changecoin.adapterlist.BaseDataBindAdapter
import com.app.changecoin.databinding.FragmentLoginBinding
import com.app.changecoin.extension.injectViewModel
import com.app.changecoin.injection.factory.ViewModelFactory
import com.app.changecoin.model.DataPerson
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
