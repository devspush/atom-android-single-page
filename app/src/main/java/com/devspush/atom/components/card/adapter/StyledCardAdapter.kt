package com.devspush.atom.components.card.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devspush.atom.R
import com.devspush.atom.components.card.holder.StyledCardViewHolder
import com.devspush.atom.components.card.interfaces.OnItemClickListener
import com.devspush.atom.components.card.model.StyledCardItem
import com.devspush.atom.extensions.inflate

class StyledCardAdapter(private var items: ArrayList<StyledCardItem>) :
    RecyclerView.Adapter<StyledCardViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StyledCardViewHolder {
        return StyledCardViewHolder(parent.inflate(R.layout.adapter_card_styled, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StyledCardViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}