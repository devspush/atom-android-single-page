package com.devspush.atom.menu.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.devspush.atom.menu.interfaces.OnNavigationItemClickListener
import com.devspush.atom.menu.model.NavigationItem
import com.devspush.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.adapter_navigation_item.view.*

class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private lateinit var item: NavigationItem
    private lateinit var onNavigationItemClickListener: OnNavigationItemClickListener

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: NavigationItem, onNavigationItemClickListener: OnNavigationItemClickListener) {
        this.item = item
        this.onNavigationItemClickListener = onNavigationItemClickListener

        itemView.tvNavCategoryItem.text = item.title
        if (SharedPrefs(itemView.context).isRtlEnabled) {
            itemView.ivNavCategory.rotation = 180f
        }
    }

    override fun onClick(v: View) {
        onNavigationItemClickListener.onNavigationItemClick(v, item)
    }
}