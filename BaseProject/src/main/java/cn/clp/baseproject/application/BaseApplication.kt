package cn.clp.baseproject.application

import android.app.Application
import android.util.Log
import cn.clp.common.utils.GlobalContextUtil
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
}