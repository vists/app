package com.app.changecoin.delegate

import com.app.changecoin.viewmodel.base.BaseViewModel
import kotlin.reflect.KProperty

class BindableDelegate<in R:BaseViewModel,T:Any>(private var value:T,private val bindingEntry:Int) {

    operator fun getValue(thisRef:R,property: KProperty<*>):T = value

            operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {
                this.value = value
                thisRef.notifyPropertyChanged(bindingEntry)
            }


}