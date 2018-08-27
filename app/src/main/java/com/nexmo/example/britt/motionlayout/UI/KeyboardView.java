package com.nexmo.example.britt.motionlayout.UI;

import android.content.Context;
import android.util.AttributeSet;

import com.nexmo.example.britt.motionlayout.R;

import androidx.constraintlayout.widget.ConstraintLayout;

public class KeyboardView extends ConstraintLayout {
    public KeyboardView(Context context) {
        super(context);
        inflate(context, R.layout.keypad, this);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
