package com.devspush.atom.components.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devspush.atom.R
import com.devspush.atom.menu.adapter.SubMenuAdapter
import com.devspush.atom.menu.interfaces.OnNavigationItemClickListener
import com.devspush.atom.menu.model.NavigationItem
import com.devspush.atom.util.ActivityUtil
import com.devspush.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.activity_sub_menu.*

class SubMenuActivity : AppCompatActivity(), View.OnClickListener, OnNavigationItemClickListener {

    private var item: NavigationItem? = null
    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(R.layout.activity_sub_menu)
        supportActionBar?.hide()

        initLayout()
        initListeners()
    }

    private fun initLayout() {
        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.parent)

        item = intent.getParcelableExtra("NAVIGATION_ITEM")

        toolbarTitle.text = item?.title
        rvSubMenu.layoutManager = LinearLayoutManager(this)
        rvSubMenu.adapter = SubMenuAdapter(item?.navigationList as ArrayList, this)
    }

    private fun getLayoutDirection(): Int {
        return if (prefs.isRtlEnabled) {
            ivBack.rotation = 180f
            ViewCompat.LAYOUT_DIRECTION_RTL
        }
        else {
            ViewCompat.LAYOUT_DIRECTION_LOCALE
        }
    }

    private fun initListeners() {
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            ivBack -> {
                onBackPressed()
            }
        }
    }

    override fun onNavigationItemClick(view: View, item: NavigationItem) {
        when (item.id) {

        }
    }
}