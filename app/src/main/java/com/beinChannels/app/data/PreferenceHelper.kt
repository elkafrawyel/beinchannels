package com.beinChannels.app.data

import android.content.Context
import android.preference.PreferenceManager

class PreferenceHelper(private val context: Context) {
    companion object {
        private const val USERNAME = "user_name"
        private const val PASSWORD = "password"
    }

    private val preference = PreferenceManager.getDefaultSharedPreferences(context)

    var userName = preference.getString(USERNAME, "ZHD13")
        set(value) = preference.edit().putString(USERNAME, value).apply()

    var password = preference.getString(PASSWORD, "ZHD13")
        set(value) = preference.edit().putString(PASSWORD, value).apply()

}