package com.devspush.atom.extensions

import android.content.Intent
import androidx.fragment.app.Fragment
import com.devspush.atom.components.base.SubMenuActivity
import com.devspush.atom.menu.model.NavigationItem

fun Fragment.openSubMenuActivity(item: NavigationItem) {
    val intent = Intent(this.context, SubMenuActivity::class.java)
    intent.putExtra("NAVIGATION_ITEM", item)
    startActivity(intent)
}