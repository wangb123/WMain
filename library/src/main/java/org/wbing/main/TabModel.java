package org.wbing.main;

import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;

/**
 * 首页底部数据
 *
 * @author 10213 on 2017/11/3.
 */

public class TabModel {

    /**
     * tab id
     */
    @IdRes
    private final int id;
    /**
     * 图标
     */
    @DrawableRes
    private final int icon;
    /**
     * 文字
     */
    private final CharSequence title;
    /**
     * 页面
     */
    private final Fragment page;

    public TabModel(@IdRes int id, @DrawableRes int icon, CharSequence title, Fragment page) {
        this.id = id;
        this.icon = icon;
        this.title = title;
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public int getIcon() {
        return icon;
    }

    public CharSequence getTitle() {
        return title;
    }

    public Fragment getPage() {
        return page;
    }


}
