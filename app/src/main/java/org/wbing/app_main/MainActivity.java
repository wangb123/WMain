package org.wbing.app_main;


import android.widget.Toast;

import org.wbing.app_main.databinding.ActivityMainBinding;
import org.wbing.base.ui.impl.WAct;
import org.wbing.main.OnPageChangeListener;
import org.wbing.main.TabModel;

public class MainActivity extends WAct<ActivityMainBinding> implements OnPageChangeListener {


    @Override
    public int layoutId() {
        return 0;
    }

    @Override
    public void loadData() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new MainFragment())
                .commit();
    }

    @Override
    public void recycle() {

    }

    @Override
    public void onPageSelected(int index, TabModel tabModel) {
        Toast.makeText(getContext(), tabModel.getTitle(), Toast.LENGTH_LONG).show();
    }
}
