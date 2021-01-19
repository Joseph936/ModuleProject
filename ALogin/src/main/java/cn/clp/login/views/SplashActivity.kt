package cn.clp.login.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.MMKVUtil
import com.alibaba.android.arouter.launcher.ARouter

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //起始页不调用setContent()方法，节约加载时间
    }

    override fun onResume() {
        super.onResume()
        goToHomeActivity()
    }

    /**
     * 跳转到home 页
     */
    private fun goToHomeActivity() {
        var isLogin: Boolean = MMKVUtil.getKVBoolean(MMKVUtil.LOGIN_STATUS)
        if (isLogin) {
            ARouter.getInstance().build(ARouterConfig.HOME_ACTIVITY_PATH).navigation()
            finish()
        } else {
            LoginActivity.startLoginActivity(this)
            finish()
        }
    }

}