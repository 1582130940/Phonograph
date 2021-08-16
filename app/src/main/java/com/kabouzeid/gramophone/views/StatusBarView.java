package com.kabouzeid.gramophone.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

public class StatusBarView extends View {

    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.height = insets.getSystemWindowInsetTop();
        setLayoutParams(lp);
        return super.onApplyWindowInsets(insets);
    }

}
