package com.devspush.atom.components.card.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devspush.atom.R
import com.devspush.atom.components.card.adapter.StyledCardAdapter
import com.devspush.atom.components.card.interfaces.OnItemClickListener
import com.devspush.atom.components.card.model.StyledCardItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class StyledCardFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<StyledCardItem>
    private lateinit var adapter: StyledCardAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_STYLED_DATA) ?: arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_list, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        adapter = StyledCardAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: StyledCardItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(viewLayout.context, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }


    companion object {
        const val CARD_STYLED_DATA = "CARD_STYLED_DATA"
        fun newInstance(viewItems: ArrayList<StyledCardItem>): StyledCardFragment {
            val fragment = StyledCardFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_STYLED_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}