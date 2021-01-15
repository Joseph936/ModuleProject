package cn.clp.login.views

import android.os.Bundle
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.login.R
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.viewModel.SplashViewModel

class SplashActivity : BaseActivity() {
    private lateinit var viewModel: SplashViewModel
    private lateinit var splashBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        super.initView()
        splashBinding = childViewBinding as ActivitySplashBinding;
    }

    override fun initData() {
        super.initData()
        viewModel = SplashViewModel()
        viewModel.registerViewModel(splashBinding)
    }

    override fun showTitleView(): Boolean {
        return false
    }

}