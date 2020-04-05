package com.devspush.atom.util

import android.content.Context
import android.content.SharedPreferences
import com.devspush.atom.R

class SharedPrefs(context: Context) {

    private var prefs = context.getSharedPreferences("shared_data", Context.MODE_PRIVATE)

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isWizardVisible: Boolean
        get() = prefs.getBoolean("WIZARD_VISIBLE", true)
        set(value) = prefs.edit { it.putBoolean("WIZARD_VISIBLE", value) }

    var isRtlEnabled: Boolean
        get() = prefs.getBoolean("RTL_ENABLED", false)
        set(value) = prefs.edit { it.putBoolean("RTL_ENABLED", value) }

    var colorTheme: Int
        get() = prefs.getInt("THEME_KEY", R.style.AppTheme)
        set(value) = prefs.edit { it.putInt("THEME_KEY", value) }
}