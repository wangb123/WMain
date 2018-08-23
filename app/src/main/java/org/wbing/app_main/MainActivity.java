package org.wbing.app_main;


import org.wbing.app_main.databinding.ActivityMainBinding;
import org.wbing.base.ui.impl.WAct;

public class MainActivity extends WAct<ActivityMainBinding> {


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

}
