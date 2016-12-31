package com.ammorteza.architectureconference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by ammorteza on 12/29/16.
 */
public class SquareLinearLayout extends LinearLayout {
    public SquareLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec , heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), (int) (getMeasuredWidth() * 1.5));
    }
}
