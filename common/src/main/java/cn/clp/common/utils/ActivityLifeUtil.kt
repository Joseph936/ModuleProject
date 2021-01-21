package cn.clp.common.utils

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle

class ActivityLifeUtil : Application.ActivityLifecycleCallbacks {
    private var context = GlobalContextUtil.newInstance().getContext()
    private var activityMap = HashMap<Int, Activity>()
    private var foregroundActivityCount = 0

    companion object {
        fun newInstance(): ActivityLifeUtil {
            return ActivityLifeUtilInner.newInstance
        }
    }

    private constructor()

    fun init() {
        var application = context as Application
        application.registerActivityLifecycleCallbacks(this)
//        application.unregisterActivityLifecycleCallbacks()
    }

    private class ActivityLifeUtilInner {
        companion object {
            var newInstance = ActivityLifeUtil()
        }
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStarted(activity: Activity) {
        foregroundActivityCount++
    }

    override fun onActivityDestroyed(activity: Activity) {
        unregisterActivity(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {
        foregroundActivityCount--
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        registerActivity(activity);
    }

    override fun onActivityResumed(activity: Activity) {
    }

    private fun registerActivity(activity: Activity) {
        activityMap[activity.hashCode()] = activity
    }

    private fun unregisterActivity(activity: Activity) {
        activityMap.remove(activity.hashCode())
    }

    /**
     * 应用在后台
     */
    fun isAppInBackground(): Boolean {
        return foregroundActivityCount <= 0
    }

    /**
     * 当前存活Activity存活数量
     */
    fun getActiveActivityCount(): Int {
        return activityMap.size
    }

    /**
     * 退出所有activity
     */
    fun clearAllActivity() {
        for (activity in activityMap.values) {
            activityMap.remove(activity.hashCode())
            activity.finish()
        }
    }

    /**
     * 重新启动应用
     */
    fun restartApp() {
        clearAllActivity()
        ToastUtil.showToast("重新启动中...")
        var packageManger = context.packageManager
        val intent = packageManger.getLaunchIntentForPackage(context.packageName)
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)

    }
}