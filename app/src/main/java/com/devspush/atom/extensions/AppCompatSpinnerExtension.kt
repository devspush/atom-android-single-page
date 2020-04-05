package com.devspush.atom.extensions

import android.content.Context
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner

fun AppCompatSpinner.createSingleChoiceDropDown(
    context: Context,
    dropDownList: Array<String>,
    spinnerItem: Int,
    spinnerDropDownItem: Int) {
    val monthAdapter = ArrayAdapter(
        context,
        spinnerItem,
        dropDownList
    )
    monthAdapter.setDropDownViewResource(spinnerDropDownItem)
    this.adapter = monthAdapter
    this.setSelection(0)
}
