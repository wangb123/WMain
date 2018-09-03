package org.wbing.main

import android.content.Context
import android.support.v4.view.ViewPager
import android.view.ViewGroup
import android.widget.RadioGroup
import org.wbing.base.ui.impl.WFrag
import org.wbing.main.databinding.WMainPageBinding

/**
 * @author wangbing
 * @date 2018/8/20
 */
abstract class WMainFrag : WFrag<WMainPageBinding>() {

    private var mOnPageChangeListener: OnPageChangeListener? = null
    private var adapter: MainAdapter? = null
    private var onPageChangeListener = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            val id = adapter?.getItemId(position)!!.toInt()
            val tabButton = getBinding()?.tabs?.findViewById<TabButton>(id)
            tabButton?.isChecked = true
            mOnPageChangeListener?.onPageSelected(position, adapter?.getModel(position))
        }
    }

    override fun layoutId(): Int {
        return R.layout.w_main_page
    }

    override fun onPostViewCreate() {
        super.onPostViewCreate()
        initAdapter()
        initPages()
        initTabs()
    }

    private fun initAdapter() {
        adapter = MainAdapter(childFragmentManager, tabs())
    }

    private fun initPages() {
        getBinding()!!.pages.adapter = adapter
        getBinding()!!.pages.addOnPageChangeListener(onPageChangeListener)
        getBinding()!!.pages.setNoScroll(!canScrollPage())
    }

    private fun initTabs() {
        for (i in 0 until adapter?.count!!) {
            val radioButton = getTabView()
            radioButton.setOnClickListener {
                if (!onTabClick(it as TabButton)) {
                    getBinding()?.pages?.setCurrentItem(getPagePositionByTabButton(it), canScrollPage())
                }
            }
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, adapter?.getPageIcon(i)!!, 0, 0)
            radioButton.text = adapter?.getPageTitle(i)
            radioButton.id = adapter?.getItemId(i)!!.toInt()
            getBinding()?.tabs?.addView(radioButton, RadioGroup.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1f))
        }

        getHandler()?.postDelayed({
            if (!activity?.isFinishing!!) {
                onPageChangeListener.onPageSelected(getBinding()?.pages?.currentItem!!)
            }
        }, 300)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnPageChangeListener) {
            mOnPageChangeListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        mOnPageChangeListener = null
    }

    /**
     * 是否由子类处理tab点击
     */
    open fun onTabClick(tabButton: TabButton): Boolean {
        return false
    }

    /**
     * 底部数据
     */
    abstract fun tabs(): Array<TabModel?>?

    /**
     * 底部view
     *
     * @return view
     */
    abstract fun getTabView(): TabButton

    /**
     * 根据TabButton获取对应的界面，防止出现添加其他的view获取page错乱的情况出现
     */
    open fun getPagePositionByTabButton(tabButton: TabButton): Int {
        return getBinding()!!.tabs.indexOfChild(tabButton)
    }

    /**
     * 设置页面是否可滑动，默认不可滑动
     */
    open fun canScrollPage(): Boolean {
        return false
    }

}
