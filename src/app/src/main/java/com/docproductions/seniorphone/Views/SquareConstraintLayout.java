package com.docproductions.seniorphone.Views;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

public class SquareConstraintLayout extends ConstraintLayout {
    public SquareConstraintLayout(Context context) {
        super(context);
    }

    public SquareConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareConstraintLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Ensure that the view is at least as tall as it is wide
        super.onMeasure(widthMeasureSpec, heightMeasureSpec < widthMeasureSpec ? widthMeasureSpec : heightMeasureSpec);
    }
}
