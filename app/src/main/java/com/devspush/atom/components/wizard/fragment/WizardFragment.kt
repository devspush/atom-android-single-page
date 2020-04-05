package com.devspush.atom.components.wizard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.devspush.atom.R
import com.devspush.atom.components.wizard.model.WizardViewItem
import com.devspush.atom.extensions.load
import kotlinx.android.synthetic.main.fragment_wizard_page.view.*

class WizardFragment : Fragment() {

    private lateinit var viewLayout: View
    private var wizardViewItem: WizardViewItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wizardViewItem = arguments?.getParcelable(WIZARD_ITEM_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_wizard_page, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        viewLayout.tvTitle.text = wizardViewItem?.title
        viewLayout.tvSubtitle.text = wizardViewItem?.subtitle
        wizardViewItem?.backgroundDrawableRes?.let { viewLayout.ivPlaceHolder.load(it) }
    }

    companion object {
        private const val WIZARD_ITEM_DATA = "WIZARD_ITEM_DATA"
        fun newInstance(item: WizardViewItem): WizardFragment {
            val fragment = WizardFragment()
            val args = Bundle()
            args.putParcelable(WIZARD_ITEM_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}