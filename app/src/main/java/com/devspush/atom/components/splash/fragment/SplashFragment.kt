package com.devspush.atom.components.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.devspush.atom.R
import com.devspush.atom.components.splash.model.SplashScreenViewItem
import kotlinx.android.synthetic.main.fragment_splash.view.*

class SplashFragment: Fragment() {

    private lateinit var viewLayout: View
    private lateinit var splashScreenView: SplashScreenViewItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashScreenView = arguments?.getParcelable(SPLASH_SCREEN_TAG)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_splash, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        viewLayout.ivSplashLogo.setImageDrawable(ContextCompat.getDrawable(viewLayout.context, splashScreenView.imgLogo))
    }

    companion object {
        private const val SPLASH_SCREEN_TAG = "SPLASH_SCREEN"
        fun newInstance(splashScreenView: SplashScreenViewItem): SplashFragment {
            val fragment = SplashFragment()
            val args = Bundle()
            args.putParcelable(SPLASH_SCREEN_TAG, splashScreenView)
            fragment.arguments = args
            return fragment
        }
    }
}