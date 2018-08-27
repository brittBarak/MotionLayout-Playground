package com.nexmo.example.britt.motionlayout

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_recyclerview.*


class RecyclerViewFragment : SimpleFragment() {
    private lateinit var listener: ViewPager.OnPageChangeListener

    private lateinit var mLinearLayoutManager: LinearLayoutManager


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val data = mutableListOf<String>()
        for (i in 0..1000) {
            data.add("data $i")
        }

        mLinearLayoutManager = LinearLayoutManager(context)
        recycler_view.apply {
            adapter = MyAdapter(data)
            layoutManager = mLinearLayoutManager
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy == 0) return
                    scroll(dy)
                }


            })
        }
    }

    fun scroll(dy: Int) {
        val firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition()
        val lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition()
        val pos = IntArray(2)
        var height = recycler_view.getHeight().toFloat()
        val offset = height * .2f
        height *= .6f

//        for (int i = firstVisibleItemPosition; i <= lastVisibleItemPosition; ++i) {
//            MyAdapter.MyViewHolder holder = (MyAdapter.MyViewHolder) mRecyclerView.findViewHolderForAdapterPosition(i);
//            holder.mLayout.getLocationInWindow(pos);
//            holder.mLayout.setProgress((pos[1] - offset) / height);
//            holder.mLayout.setProgress((i-firstVisibleItemPosition)/(float)(lastVisibleItemPosition-firstVisibleItemPosition));
//            holder.mLayout.setProgress(dy);


        val holder = recycler_view.findViewHolderForAdapterPosition(firstVisibleItemPosition) as MyAdapter.MyViewHolder
        holder!!.mLayout.transitionToEnd()

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int = R.layout.fragment_recyclerview) =
                RecyclerViewFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_LAYOUT_ID, param1)
                    }
                }
    }

    internal inner class MyAdapter(private val mDataset: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        inner class MyViewHolder(var mLayout: MotionLayout) : RecyclerView.ViewHolder(mLayout) {
            internal var b: Button

            init {
                b = mLayout.findViewById<View>(R.id.button) as Button
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup,
                                        viewType: Int): MyAdapter.MyViewHolder {
            val v = LayoutInflater.from(parent.context)
                    .inflate(R.layout.motion_item, parent, false) as MotionLayout

            return MyViewHolder(v)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.mLayout.progress = 0f
            holder.b.text = mDataset[position]
            //            setFadeAnimation(holder.itemView);

        }

        override fun getItemCount(): Int {
            return mDataset.size
        }

        //        private void setFadeAnimation(View view) {
        //            AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        //            anim.setDuration(1000);
        //            view.startAnimation(anim);
        //        }
    }
}






