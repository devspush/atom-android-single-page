package com.devspush.atom.menu.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.devspush.atom.extensions.openWebUrl
import com.devspush.atom.util.AtomConstants
import kotlinx.android.synthetic.main.adapter_navigation_header_item.view.*

class NavigationHeaderItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    init {
        itemView.btnNavPurchaseNow.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        v.openWebUrl(AtomConstants.DEV_PUSH_URL)
    }
}