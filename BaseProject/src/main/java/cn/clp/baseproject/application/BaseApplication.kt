package cn.clp.baseproject.application

import android.app.Activity
import android.app.Application
import android.util.Log
import cn.clp.common.configs.AppConfig
import cn.clp.common.utils.GlobalContextUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV
import me.jessyan.autosize.AutoSizeConfig
import me.jessyan.autosize.onAdaptListener
import me.jessyan.autosize.utils.ScreenUtils

abstract class BaseApplication : Application(), onAdaptListener {
    override fun onCreate() {
        super.onCreate()
        GlobalContextUtil.newInstance().init(this)
    }

    /**
     * 初始化MMKV
     */
    protected fun initMMKV(application: Application) {
        var rootDir: String = MMKV.initialize(application)
        Log.i("CLP", "rootDir:" + rootDir)
    }

    /**
     * 初始化路由机制
     */
    protected fun initARouter(context: Application) {
        if (!AppConfig.IS_RELEASE) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(context); // As early as possible, it is recommended to initialize in the Application

    }

    /**
     * 初始化是适配方案
     */
    protected fun initAutoSize() {
        var config:AutoSizeConfig=  AutoSizeConfig.getInstance()
        config.isCustomFragment=true//是否让框架支持自定义 Fragment 的适配参数, 由于这个需求是比较少见的, 所以须要使用者手动开启
        config.isExcludeFontScale=true//是否屏蔽系统字体大小对 AndroidAutoSize 的影响
        config.onAdaptListener=this
        config.setLog(!AppConfig.IS_RELEASE)//是否打印 AutoSize 的内部日志, 默认为 true, 如果您不想 AutoSize 打印日志, 则请设置为 false
        config.isUseDeviceSize=true     //在全面屏或刘海屏幕设备中, 获取到的屏幕高度可能不包含状态栏高度, 所以在全面屏设备中不需要减去状态栏高度，所以可以 setUseDeviceSize(true)
//        config.isBaseOnWidth = true
    }

    //AUtoSize 适配框架，解决横竖屏切换时的屏幕适配问题
    override fun onAdaptBefore(target: Any?, activity: Activity?) {
        AutoSizeConfig.getInstance().screenWidth = ScreenUtils.getScreenSize(activity)[0]
        AutoSizeConfig.getInstance().screenHeight = ScreenUtils.getScreenSize(activity)[1]
    }

    //AUtoSize 适配框架，切换屏幕之后处理
    override fun onAdaptAfter(target: Any?, activity: Activity?) {
    }


}