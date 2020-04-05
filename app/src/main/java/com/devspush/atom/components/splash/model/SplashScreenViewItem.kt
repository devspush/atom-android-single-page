package com.devspush.atom.components.splash.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SplashScreenViewItem(val title: String, @DrawableRes val imgLogo: Int) : Parcelable