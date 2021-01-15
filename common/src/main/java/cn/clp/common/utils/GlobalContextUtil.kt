package cn.clp.common.utils

import android.content.Context

class GlobalContextUtil {
    companion object {
        fun newInstance(): GlobalContextUtil {
            return GlobalContextInner.newInstance
        }
    }

    private lateinit var context: Context
    fun getContext(): Context {
        return context
    }

    fun init(context: Context) {
        this.context = context
    }


    class GlobalContextInner {
        companion object {
            var newInstance: GlobalContextUtil = GlobalContextUtil()
        }
    }
}