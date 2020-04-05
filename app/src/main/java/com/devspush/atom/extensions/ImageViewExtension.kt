package com.devspush.atom.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devspush.atom.R
import com.devspush.atom.util.SquareImageView


fun ImageView.load(imageUrl: String, isRounded: Boolean = false) {
    if (isRounded) {
        Glide.with(context)
            .setDefaultRequestOptions(getRequestOptions())
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    } else {
        Glide
            .with(this)
            .setDefaultRequestOptions(getRequestOptions())
            .load(imageUrl)
            .into(this)
    }
}


fun SquareImageView.load(imageUrl: String, isRounded: Boolean = false) {
    if (isRounded) {
        Glide.with(context)
            .setDefaultRequestOptions(getRequestOptions())
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    } else {
        Glide
            .with(this)
            .setDefaultRequestOptions(getRequestOptions())
            .load(imageUrl)
            .into(this)
    }
}

fun ImageView.load(@DrawableRes drawable: Int, isRounded: Boolean = false) {
    if (isRounded) {
        Glide.with(context)
            .setDefaultRequestOptions(getRequestOptions())
            .load(drawable)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    } else {
        Glide
            .with(this)
            .setDefaultRequestOptions(getRequestOptions())
            .load(drawable)
            .into(this)
    }
}

fun SquareImageView.load(@DrawableRes drawable: Int, isRounded: Boolean = false) {
    if (isRounded) {
        Glide.with(context)
            .setDefaultRequestOptions(getRequestOptions())
            .load(drawable)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    } else {
        Glide
            .with(this)
            .setDefaultRequestOptions(getRequestOptions())
            .load(drawable)
            .into(this)
    }
}

private fun getRequestOptions(): RequestOptions {
    val requestOptions = RequestOptions()
    requestOptions.placeholder(R.drawable.placeholder)
    requestOptions.error(R.drawable.placeholder)
    return requestOptions
}

fun ImageView.setImageBgFromDrawable(@DrawableRes drawable: Int) {
    background = ContextCompat.getDrawable(context, drawable)
}