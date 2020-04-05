package com.devspush.atom.extensions

import android.widget.Button
import com.devspush.atom.R

//
// Created by  on 3/9/20.
//

fun Button.setButtonText(isFollowing: Boolean) {
    if (isFollowing) {
        this.text = this.context.getString(R.string.list_button_text_2)
    }else {
        this.text = this.context.getString(R.string.list_button_text_5)
    }
}