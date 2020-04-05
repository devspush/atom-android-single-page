package com.devspush.atom.extensions

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun View.hitTest(x: Int, y: Int): Boolean {
    val tx = (translationX + 0.5f).toInt()
    val ty = (translationY + 0.5f).toInt()
    val left = left + tx
    val right = right + tx
    val top = top + ty
    val bottom = bottom + ty
    return x in left..right && y >= top && y <= bottom
}

fun View.openWebUrl(url: String) {
    this.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}