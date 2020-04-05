package com.devspush.atom.components.card.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.devspush.atom.R
import com.devspush.atom.components.base.GenericActivity
import com.devspush.atom.components.card.fragment.StyledCardFragment
import com.devspush.atom.components.card.model.StyledCardItem
import com.devspush.atom.components.card.repository.StyledCardRepository
import io.reactivex.rxkotlin.subscribeBy

class StyledCardActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.styled_cards))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        StyledCardRepository.getData(this).subscribeBy {
            callback.invoke(StyledCardFragment.newInstance(it as ArrayList<StyledCardItem>))
        }
    }

    override fun loadTag(): String {
        return "StyledCardTag"
    }
}