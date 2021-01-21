package cn.clp.common.utils

import android.content.Context

class GlobalContextUtil {
    private var context: Context? = null

    companion object {
        fun newInstance(): GlobalContextUtil {
            return GlobalContextInner.newInstance
        }
    }

    private constructor()

    fun init(context: Context) {
        this.context = context
    }

    fun getContext(): Context {
        return context!!
    }

    class GlobalContextInner {
        companion object {
            var newInstance = GlobalContextUtil()
        }
    }
}