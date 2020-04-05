package com.devspush.atom.components.card.repository

import android.content.Context
import com.devspush.atom.R
import com.devspush.atom.components.card.model.StyledCardItem
import io.reactivex.Observable

object StyledCardRepository {

    fun getData(context: Context): Observable<List<StyledCardItem>> {
        val list = mutableListOf<StyledCardItem>()

        list.add(
            StyledCardItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_1
            )
        )
        list.add(
            StyledCardItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )
        list.add(
            StyledCardItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_3
            )
        )
        list.add(
            StyledCardItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )
        list.add(
            StyledCardItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_1
            )
        )
        list.add(
            StyledCardItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_3
            )
        )
        return Observable.just(list)
    }
}