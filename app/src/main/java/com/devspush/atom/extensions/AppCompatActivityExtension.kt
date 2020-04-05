package com.devspush.atom.extensions

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.devspush.atom.R

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}


fun FragmentActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun AppCompatActivity.screenWidth(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.widthPixels
}

fun AppCompatActivity.screenHeight(): Int {
    val metrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(metrics)
    return metrics.heightPixels
}

fun AppCompatActivity.color(resId: Int): Int {
    return ContextCompat.getColor(this, resId)
}


fun AppCompatActivity.setSelectedTabTextColor(
    context: Context, value: TypedValue,
    tv1: TextView, tv2: TextView, tv3: TextView
) {
    this.theme.resolveAttribute(R.attr.colorBgPrimaryLight, value, true)
    tv1.setTextColor(value.data)
    tv2.setTextColor(ContextCompat.getColor(context, R.color.colorTextWhite))
    tv3.setTextColor(ContextCompat.getColor(context, R.color.colorTextWhite))
}