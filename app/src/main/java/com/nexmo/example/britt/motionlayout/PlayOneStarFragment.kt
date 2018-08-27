package com.nexmo.example.britt.motionlayout


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PlayOneStarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_play_one_star, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String? = null, param2: String? = null) =
                PlayOneStarFragment().apply {
                }
    }
}
