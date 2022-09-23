package com.kabouzeid.gramophone.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class WidthFitSquareLayout extends FrameLayout {

    private boolean forceSquare = true;

    public WidthFitSquareLayout(Context context) {
        super(context);
    }

    public WidthFitSquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WidthFitSquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WidthFitSquareLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //noinspection SuspiciousNameCombination
        super.onMeasure(widthMeasureSpec, forceSquare ? widthMeasureSpec : heightMeasureSpec);
    }

    public void forceSquare(boolean forceSquare) {
        this.forceSquare = forceSquare;
        requestLayout();
    }
}
