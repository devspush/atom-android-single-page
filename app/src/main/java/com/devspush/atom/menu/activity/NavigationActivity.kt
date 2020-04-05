package com.devspush.atom.menu.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.devspush.atom.R
import com.devspush.atom.extensions.replaceFragment
import com.devspush.atom.menu.adapter.NavigationAdapter
import com.devspush.atom.menu.fragment.HomeFragment
import com.devspush.atom.menu.fragment.SubMenuFragment
import com.devspush.atom.menu.interfaces.OnNavigationItemClickListener
import com.devspush.atom.menu.model.NavigationItem
import com.devspush.atom.menu.repository.MenuRepository
import com.devspush.atom.util.ActivityUtil
import com.devspush.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class NavigationActivity : AppCompatActivity(), OnNavigationItemClickListener {

    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }
    private val navigationAdapter = NavigationAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.drawerLayout)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        initMenuList()
        loadHomeFrame()
    }

    private fun getLayoutDirection(): Int {
        return if (prefs.isRtlEnabled) {
            ViewCompat.LAYOUT_DIRECTION_RTL
        }
        else {
            ViewCompat.LAYOUT_DIRECTION_LOCALE
        }
    }

    @SuppressLint("CheckResult")
    private fun initMenuList() {
        rvNavigation.layoutManager = LinearLayoutManager(this)
        rvNavigation.adapter = navigationAdapter
        MenuRepository.getData(this).subscribe {
            navigationAdapter.setData(it)
        }
    }

    private fun loadHomeFrame() {
        replaceFragment(
            HomeFragment.newInstance(),
            R.id.main_container
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemClick(view: View, item: NavigationItem) {
        replaceFragment(
            SubMenuFragment.newInstance(item.navigationList as ArrayList<NavigationItem>),
            R.id.main_container
        )
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
