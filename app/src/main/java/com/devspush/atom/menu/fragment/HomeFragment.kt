package com.devspush.atom.menu.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devspush.atom.R
import com.devspush.atom.extensions.openWebUrl
import com.devspush.atom.util.AtomConstants
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_home, container, false))
        return viewLayout
    }
    private fun loadView(view: View) {
        viewLayout = view

        initListeners()
    }

    private fun initListeners() {
        viewLayout.btnPurchase.setOnClickListener(this)
        viewLayout.btnDevPush.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            viewLayout.btnPurchase,
            viewLayout.btnDevPush -> {
                v?.openWebUrl(AtomConstants.DEV_PUSH_URL)
            }
        }
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}