package com.devspush.atom.menu.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devspush.atom.R
import com.devspush.atom.components.card.activity.StyledCardActivity
import com.devspush.atom.menu.adapter.SubMenuAdapter
import com.devspush.atom.menu.interfaces.OnNavigationItemClickListener
import com.devspush.atom.menu.model.NavigationItem
import com.devspush.atom.menu.model.NavigationItemType
import kotlinx.android.synthetic.main.fragment_sub_menu.view.*

class SubMenuFragment : Fragment(), OnNavigationItemClickListener {

    private lateinit var viewLayout: View
    private var items = arrayListOf<NavigationItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(NAVIGATION_ITEM_LIST)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_sub_menu, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        viewLayout.rvSubMenu.layoutManager = LinearLayoutManager(viewLayout.context)
        viewLayout.rvSubMenu.adapter = SubMenuAdapter(items, this)
    }
    override fun onNavigationItemClick(view: View, item: NavigationItem) {
        when (item.id) {
            NavigationItemType.LIST_GOOGLE_CARDS_1 -> {
                startActivity(Intent(view.context, StyledCardActivity::class.java))
            }
        }
    }

    companion object {
        private const val NAVIGATION_ITEM_LIST = "NAVIGATION_ITEM_LIST"
        fun newInstance(items: ArrayList<NavigationItem>): SubMenuFragment {
            val fragment = SubMenuFragment()
            val args = Bundle()
            args.putParcelableArrayList(NAVIGATION_ITEM_LIST, items)
            fragment.arguments = args
            return fragment
        }
    }
}