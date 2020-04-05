package com.devspush.atom.components.base

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.devspush.atom.R
import com.devspush.atom.components.wizard.adapter.WizardPagerAdapter
import com.devspush.atom.components.wizard.fragment.WizardFragment
import com.devspush.atom.components.wizard.repository.WizardRepository
import com.devspush.atom.extensions.openWebUrl
import com.devspush.atom.menu.activity.NavigationActivity
import com.devspush.atom.util.AtomConstants
import com.devspush.atom.util.SharedPrefs
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_wizard_base.*

class WizardActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, View.OnClickListener {

    private lateinit var adapter: WizardPagerAdapter

    private val prefs: SharedPrefs by lazy {
        SharedPrefs(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wizard_base)

        initLayout()
        initListeners()
    }

    @SuppressLint("CheckResult")
    private fun initLayout() {
        tvPrev.visibility = View.INVISIBLE
        adapter = WizardPagerAdapter(
            supportFragmentManager
        )
        WizardRepository.getData(this).subscribeBy {
            adapter.addFragment(WizardFragment.newInstance(it))
        }
        viewPager.adapter = adapter
        tabDots.setupWithViewPager(viewPager)
    }

    private fun initListeners() {
        viewPager.addOnPageChangeListener(this)
        tvPrev.setOnClickListener(this)
        tvNext.setOnClickListener(this)
        btnPurchase.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            tvPrev -> {
                viewPager.currentItem = tabDots.selectedTabPosition - 1
            }
            tvNext -> {
                if (tabDots.selectedTabPosition == (adapter.count - 1)) {
                    prefs.isWizardVisible = false
                    startActivity(Intent(this, NavigationActivity::class.java))
                    finish()
                } else {
                    viewPager.currentItem = tabDots.selectedTabPosition + 1
                }
            }
            btnPurchase -> {
                v.openWebUrl(AtomConstants.DEV_PUSH_URL)
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                tvPrev.visibility = View.INVISIBLE
            }
            adapter.count - 1 -> {
                tvNext.text = getString(R.string.wizard_finish)
                tvPrev.visibility = View.VISIBLE
            }
            else -> {
                tvNext.text = getString(R.string.wizard_next)
                tvPrev.visibility = View.VISIBLE
            }
        }
    }
}