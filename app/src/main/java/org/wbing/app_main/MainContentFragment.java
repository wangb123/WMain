package org.wbing.app_main;

import android.os.Bundle;

import org.wbing.app_main.databinding.FragmentMainContentBinding;
import org.wbing.base.ui.impl.WFrag;

/**
 * @author wangbing
 * @date 2018/8/23
 */
public class MainContentFragment extends WFrag<FragmentMainContentBinding> {
    public static MainContentFragment newInstance(String text) {

        Bundle args = new Bundle();
        args.putString("text", text);
        MainContentFragment fragment = new MainContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private String text;

    @Override
    public int layoutId() {
        return R.layout.fragment_main_content;
    }

    @Override
    public void loadData() {
        getBinding().text.setText(text);
    }

    @Override
    public void recycle() {

    }

    @Override
    public void getParams(Bundle args) {
        super.getParams(args);
        text = args.getString("text");
    }
}
