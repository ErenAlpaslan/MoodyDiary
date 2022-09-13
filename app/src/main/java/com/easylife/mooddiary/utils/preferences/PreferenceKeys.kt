package com.easylife.mooddiary.utils.preferences

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey

object PreferencesKeys {
    const val PREFERENCES_NAME = "MOODY_PREFERENCES"
    val IS_FIRST_ENTER = booleanPreferencesKey("IS_FIRST_ENTER")
}