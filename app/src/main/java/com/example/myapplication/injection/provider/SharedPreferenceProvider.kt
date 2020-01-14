package com.example.myapplication.injection.provider

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.R
import javax.inject.Inject

class SharedPreferenceProvider  @Inject constructor(contextApp:Context) {

        private var preferences: SharedPreferences
        private var edit: SharedPreferences.Editor


      init{
            preferences = contextApp.getSharedPreferences(contextApp.getString(R.string.app_name), Context.MODE_PRIVATE)
            edit = preferences.edit()
        }

        fun putPrefsByKey(key: String, value: String) {
            edit.putString(key, value)
            edit.apply()
        }

        fun getPrefsByKey(key: String): String? {
            return if (preferences.contains(key))
                preferences.getString(key, null)
            else
                null
        }

        fun getPrefsByKeyInteger(key: String, defaultValue: Int): Int {
            return preferences.getInt(key, defaultValue)
        }

        fun putPrefsByKeyInteger(key: String, value: Int) {
            edit.putInt(key, value)
            edit.apply()
        }


        fun removeAll() {
            edit.clear()
            edit.apply()
        }
}