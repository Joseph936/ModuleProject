package cn.clp.login.viewModel

import android.content.Context
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.MMKVUtil
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.views.LoginActivity
import com.alibaba.android.arouter.launcher.ARouter

class SplashViewModel : BaseViewModel<ActivitySplashBinding>() {
    override fun registerViewModel(context: Context, splashBinding: ActivitySplashBinding) {
        super.registerViewModel(context, splashBinding)
        splashBinding!!.let { it.splashViewModel = this }
    }

    /**
     * 跳转到home 页
     */
    fun goToHomeActivity() {
        var isLogin: Boolean = MMKVUtil.getKVBoolean(MMKVUtil.LOGIN_STATUS)
        if (isLogin) {
            ARouter.getInstance().build(ARouterConfig.HOME_ACTIVITY_PATH).navigation()
            finish()
        } else {
            context!!.let { LoginActivity.startLoginActivity(it) }
            finish()
        }
    }
}