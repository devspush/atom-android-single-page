package com.devspush.atom.components.wizard.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WizardViewItem(
    val title: String,
    val subtitle: String,
    @DrawableRes val backgroundDrawableRes: Int,
    @ColorRes val backgroundColor: Int
) : Parcelable