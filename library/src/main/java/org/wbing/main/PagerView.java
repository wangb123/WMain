package org.wbing.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @author wangbing
 * @date 2018/8/21
 */
public class PagerView extends ViewPager {
    private boolean noScroll = false;

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    public PagerView(@NonNull Context context) {
        super(context);
    }

    public PagerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return !noScroll && super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return !noScroll && super.onInterceptTouchEvent(arg0);
    }
}
