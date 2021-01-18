package cn.clp.baseproject.application

import android.app.Application
import android.content.Context
import android.util.Log
import cn.clp.baseproject.BuildConfig
import cn.clp.common.configs.AppConfig
import cn.clp.common.utils.GlobalContextUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV

abstract class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContextUtil.newInstance().init(this)
    }

    /**
     * 初始化MMKV
     */
    fun initMMKV(application: Application) {
        var rootDir: String = MMKV.initialize(application)
        Log.i("CLP", "rootDir:" + rootDir)
    }

    /**
     * 初始化路由机制
     */
    fun initARouter(context: Application) {
        if (!AppConfig.IS_RELEASE) {           // These two lines must be written before init, otherwise these configurations will be invalid in the init process
            ARouter.openLog();     // Print log
            ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        }
        ARouter.init(context); // As early as possible, it is recommended to initialize in the Application

    }
}