package cn.clp.login.viewModel

import android.view.View
import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.MMKVUtil
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.views.LoginActivity
import com.alibaba.android.arouter.launcher.ARouter

class SplashViewModel : BaseViewModel<ActivitySplashBinding>() {
    override fun initView() {
        super.initView()
        getViewDataBinding()!!.splashViewModel=this
    }

    override fun initData() {
        super.initData()
    }

    override fun initListener() {
        super.initListener()
    }

    fun closeCountDown(view: View) {
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
            LoginActivity.startLoginActivity(getContext())
            finish()
        }
    }
}