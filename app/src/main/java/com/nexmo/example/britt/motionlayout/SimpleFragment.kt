package com.nexmo.example.britt.motionlayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bottom_nav.*


internal const val ARG_LAYOUT_ID = "layoutId"

open class SimpleFragment : Fragment() {
    var layoutId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            layoutId = it.getInt(ARG_LAYOUT_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
                SimpleFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_LAYOUT_ID, param1)
                    }
                }
    }
}
