package org.wbing.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @author wangbing
 * @date 2018/8/17
 */
class MainAdapter(fm: FragmentManager?, private val list: Array<TabModel?>?) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        return list!![i]!!.page
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list!![position]!!.title
    }

    fun getPageIcon(position: Int): Int {
        return list!![position]!!.icon
    }

    override fun getItemId(position: Int): Long {
        return list!![position]!!.id.toLong()
    }
}
