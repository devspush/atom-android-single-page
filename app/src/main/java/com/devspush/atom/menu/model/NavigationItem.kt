package com.devspush.atom.menu.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NavigationItem(
    val id: NavigationItemType,
    val title: String? = "",
    val subtitle: String? = "",
    @DrawableRes val icon: Int? = -1,
    val navigationList: List<NavigationItem>? = listOf(),
    val itemType: NavigationAdapterItemType = NavigationAdapterItemType.ITEM

) : Parcelable