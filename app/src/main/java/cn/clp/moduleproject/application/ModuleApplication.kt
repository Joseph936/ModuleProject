package cn.clp.moduleproject.application

import cn.clp.baseproject.application.BaseApplication

class ModuleApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        initMMKV(this)
        initARouter(this)
    }
}