package cn.clp.login.viewModel

import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.common.utils.MMKVUtil
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.views.LoginActivity

class SplashViewModel : BaseViewModel() {
    private lateinit var splashBinding: ActivitySplashBinding
    fun registerViewModel(splashBinding: ActivitySplashBinding) {
        this.splashBinding = splashBinding
        splashBinding.splashViewModel = this
    }

    override fun initData() {
        super.initData()
        var isLogin: Boolean = MMKVUtil.getKVBoolean(MMKVUtil.LOGIN_STATUS)
        if (isLogin) {
        } else {
            LoginActivity.startLoginActivity(context)
        }
    }

}