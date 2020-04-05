package com.devspush.atom.components.wizard.repository

import android.content.Context
import com.devspush.atom.R
import com.devspush.atom.components.wizard.model.WizardViewItem
import io.reactivex.Observable

object WizardRepository {
    fun getData(context: Context): Observable<WizardViewItem> {
        val pageOne = WizardViewItem(
            title = context.getString(R.string.wizard_title_one),
            subtitle = context.getString(R.string.wizard_subtitle_one),
            backgroundDrawableRes = R.drawable.ic_wizard_1,
            backgroundColor = R.color.colorPrimary
        )
        val pageTwo = WizardViewItem(
            title = context.getString(R.string.wizard_title_two),
            subtitle = context.getString(R.string.wizard_subtitle_two),
            backgroundDrawableRes = R.drawable.ic_wizard_2,
            backgroundColor = R.color.colorPrimary
        )
        val pageThree = WizardViewItem(
            title = context.getString(R.string.wizard_title_three),
            subtitle = context.getString(R.string.wizard_subtitle_three),
            backgroundDrawableRes = R.drawable.ic_wizard_3,
            backgroundColor = R.color.colorPrimary
        )
        return Observable.just(pageOne, pageTwo, pageThree)
    }
}