package com.example.myapplication.injection.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.myapplication.R
import javax.inject.Inject

class SharedPreferenceProvider  @Inject constructor(contextApp:Context) {

        private val preferences by lazy {
            contextApp.getSharedPreferences(contextApp.getString(R.string.app_name), Context.MODE_PRIVATE)
        }

        fun putPrefsByKey(key: String, value: String) {
            preferences.edit{
                putString(key, value)
            }
        }

        fun getPrefsByKey(key: String) = preferences.getString(key, null)


        fun getPrefsByKeyInteger(key: String, defaultValue: Int) = preferences.getInt(key, defaultValue)


        fun putPrefsByKeyInteger(key: String, value: Int) {
            preferences.edit{
                putInt(key, value)
            }
        }

        fun removeAll() {
            preferences.edit{
                clear()
            }
        }
}