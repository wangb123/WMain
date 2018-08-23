package org.wbing.app_main;

import android.graphics.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.wbing.main.TabButton;
import org.wbing.main.TabModel;
import org.wbing.main.WMainFrag;
import org.wbing.main.databinding.WMainPageBinding;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public class MainFragment extends WMainFrag {
    @Override
    public void onPostViewCreate() {
        super.onPostViewCreate();
        getBinding().line.setBackgroundColor(Color.RED);
    }

    @Nullable
    @Override
    public TabModel[] tabs() {
        TabModel[] tabs = new TabModel[5];
        tabs[0] = new TabModel(R.id.app_tab1, R.drawable.app_selector_tab1, "首页", MainContentFragment.newInstance("首页"));
        tabs[1] = new TabModel(R.id.app_tab2, R.drawable.app_selector_tab2, "发现", MainContentFragment.newInstance("发现"));
        tabs[2] = new TabModel(R.id.app_tab3, R.drawable.app_selector_tab3, "中间", MainContentFragment.newInstance("中间"));
        tabs[3] = new TabModel(R.id.app_tab4, R.drawable.app_selector_tab4, "消息", MainContentFragment.newInstance("消息"));
        tabs[4] = new TabModel(R.id.app_tab5, R.drawable.app_selector_tab5, "我的", MainContentFragment.newInstance("我的"));
        return tabs;
    }

    @NotNull
    @Override
    public TabButton getTabView() {
        return new TabButton(getContext());
    }


    @Override
    public void loadData() {
        WMainPageBinding binding = getBinding();
    }

    @Override
    public void recycle() {

    }
}
