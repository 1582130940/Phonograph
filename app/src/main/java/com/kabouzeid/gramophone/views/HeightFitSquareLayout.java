package com.kabouzeid.gramophone.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class HeightFitSquareLayout extends FrameLayout {

    private boolean forceSquare = true;

    public HeightFitSquareLayout(Context context) {
        super(context);
    }

    public HeightFitSquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeightFitSquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HeightFitSquareLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(forceSquare ? heightMeasureSpec : widthMeasureSpec, heightMeasureSpec);
    }

    public void forceSquare(boolean forceSquare) {
        this.forceSquare = forceSquare;
        requestLayout();
    }
}
