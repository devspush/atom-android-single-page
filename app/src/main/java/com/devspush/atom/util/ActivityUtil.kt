package com.devspush.atom.util

import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentActivity

object ActivityUtil {

    fun reload(activity: FragmentActivity?) {
        val i = activity?.baseContext?.packageManager?.getLaunchIntentForPackage(activity.baseContext.packageName)
        i?.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP//clear the stack
        i?.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        activity?.finish()
        activity?.startActivity(i)
    }

    fun setLayoutDirection(activity: FragmentActivity, layoutDirection: Int, parent: Int) {
        ViewCompat.setLayoutDirection(activity.findViewById(parent), layoutDirection)
    }
}