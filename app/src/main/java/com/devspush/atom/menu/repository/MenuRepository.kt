package com.devspush.atom.menu.repository

import android.content.Context
import com.devspush.atom.R
import com.devspush.atom.menu.model.NavigationAdapterItemType
import com.devspush.atom.menu.model.NavigationItem
import com.devspush.atom.menu.model.NavigationItemType
import io.reactivex.Observable

object MenuRepository {

    fun getData(context: Context): Observable<List<NavigationItem>> {
        val result = mutableListOf<NavigationItem>()
        result.addAll(getHeaderItem(context))
        result.addAll(getCards(context))
        return Observable.just(result)
    }

    private fun getHeaderItem(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        result.add(
            NavigationItem(
                id = NavigationItemType.HEADER,
                title = context.getString(R.string.nav_header_title),
                subtitle = context.getString(R.string.nav_header_subtitle),
                itemType = NavigationAdapterItemType.HEADER
            )
        )
        return result
    }

    private fun getCards(context: Context): List<NavigationItem> {
        val result = mutableListOf<NavigationItem>()
        val list = mutableListOf<NavigationItem>()
        list.add(
            NavigationItem(
                id = NavigationItemType.LIST_GOOGLE_CARDS_1,
                title = context.getString(R.string.styled_cards)
            )
        )
        result.add(
            NavigationItem(
                id = NavigationItemType.MENU_CARDS,
                title = context.getString(R.string.left_menu_cards),
                navigationList = list
            )
        )
        return result
    }
}