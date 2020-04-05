package com.devspush.atom.components.card.interfaces

import com.devspush.atom.components.card.model.StyledCardItem

interface OnItemClickListener {
    fun onItemClick(item: StyledCardItem)
    fun onCommentsClick()
}