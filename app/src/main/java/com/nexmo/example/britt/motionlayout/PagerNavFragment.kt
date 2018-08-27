package com.nexmo.example.britt.motionlayout

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.fragment_viewpager.*
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import kotlinx.android.synthetic.main.pager_item.view.*
import java.util.*


class PagerNavFragment : SimpleFragment() {
    private lateinit var listener: ViewPager.OnPageChangeListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            viewpager?.let {
                viewpager.adapter = MyPagerAdapter(activity!!)

                listener = object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(state: Int) {
                    }

                    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                        motionLayout.progress = (position + positionOffset) / (viewpager.adapter!!.count - 1)

                    }

                    override fun onPageSelected(position: Int) {
                    }

                }
                viewpager.addOnPageChangeListener(listener)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewpager?.addOnPageChangeListener(listener)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
                PagerNavFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_LAYOUT_ID, param1)
                    }
                }
    }
}

class MyPagerAdapter(val context: Context) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return 3;
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.pager_item, container, false) as ViewGroup
        layout.textview.text = "Page : $position"
        container.addView(layout)
        return layout
    }

    private fun rand(): Int {
        return Random().nextInt(255)
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View?)
    }
}
