package com.devspush.atom.components.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.devspush.atom.R
import com.devspush.atom.extensions.inTransaction
import com.devspush.atom.util.ActivityUtil
import com.devspush.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.activity_generic.*

abstract class GenericActivity : AppCompatActivity() {

    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(getLayoutId())

        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.parent)
        if (supportFragmentManager.findFragmentByTag(loadTag()) == null) {
            loadFragment {
                supportFragmentManager.inTransaction {
                    add(R.id.fragment, it, loadTag())
                }
            }
        }
        setToolBar()
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

    open fun getLayoutId(): Int = R.layout.activity_generic

    abstract fun setToolBar()

    abstract fun loadFragment(callback: (f: Fragment) -> Unit)

    abstract fun loadTag(): String

    fun setToolbarTitle(title: String) {
        toolbarTitle.text = title
    }

    //if we implement the OnClickListener, then all child classes must override the onClick method
    fun onBackButtonClick(view: View) {
        onBackPressed()
    }
}