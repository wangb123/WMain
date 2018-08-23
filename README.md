#WMain文档
####使用方法：

```groovy
	implementation 'org.wbing:base:0.1.3'
	implementation 'org.wbing:main:0.0.2'
	implementation "$api_kt"//部分代码依赖kotlin，所以需要依赖
	implementation "$api_appcompat"//使用了appcompat兼容包
```


##功能说明
>使用Fragment二次封装[WBase](https://gitee.com/wbing123/expect_component/tree/master/wbase)库，框架采用ViewPager配合RadioGroup实现，可快速实现点击底部控件切换tab的效果。

继承MainFrag，实现以下抽象方法

```kotlin
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

```