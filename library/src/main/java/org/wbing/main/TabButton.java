package org.wbing.main;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * @author wangbing
 * @date 2018/8/20
 */
public class TabButton extends android.support.v7.widget.AppCompatRadioButton {
    private OnClickListener clickListener;

    public TabButton(Context context) {
        super(context);
    }

    public TabButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean performClick() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            return callOnClick();
        } else {
            clickListener.onClick(this);
            return true;
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        clickListener = l;
    }
}
