package com.nexmo.example.britt.motionlayout.UI

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.AdaptiveIconDrawable
import android.util.AttributeSet
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.content.ContextCompat
import com.nexmo.example.britt.motionlayout.R

class MyImageFilterView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ImageFilterView(context, attrs, defStyleAttr) {

    private var myDrawable: Int = 0

    fun setMyDrawable(newDrawable: Int) {
        if (newDrawable == myDrawable) return
        myDrawable = newDrawable
        when (myDrawable) {
            0 -> setImageDrawable(ContextCompat.getDrawable(context, R.drawable.circle_gradient_yellow))
            1 -> setImageDrawable(ContextCompat.getDrawable(context, R.drawable.circle_gradient_purple))
            2 -> setImageDrawable(ContextCompat.getDrawable(context, R.drawable.circle_gradient_red))
        }
    }

    fun getMyDrawable(): Int {
        return myDrawable;
    }

    init {
        context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.MyImageFilterView,
                0, 0).apply {

            try {
                myDrawable = getInteger(R.styleable.MyImageFilterView_myDrawable, 0)

            } finally {
                recycle()
            }
        }

    }

}