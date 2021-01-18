package cn.clp.login.views

import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.login.R
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.viewModel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    private var viewModel: SplashViewModel? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel? {
        viewModel = SplashViewModel()
        return viewModel
    }

    override fun initView() {
        super.initView()
    }

    override fun onResume() {
        super.onResume()
        viewModel!!.let { it.goToHomeActivity() }
    }


}