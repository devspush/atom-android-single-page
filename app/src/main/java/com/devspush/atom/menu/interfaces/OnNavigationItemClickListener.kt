package com.devspush.atom.menu.interfaces

import android.view.View
import com.devspush.atom.menu.model.NavigationItem

interface OnNavigationItemClickListener {
    fun onNavigationItemClick(view: View, item: NavigationItem)
}