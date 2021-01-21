package cn.clp.login.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.MMKVUtil
import cn.clp.login.R
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.databinding.ActivitySplashBindingImpl
import cn.clp.login.viewModel.SplashViewModel
import com.alibaba.android.arouter.launcher.ARouter

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    private var viewModel: SplashViewModel? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): SplashViewModel? {
        if (viewModel == null) viewModel = SplashViewModel()
        return viewModel
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }

    override fun initListener() {
        super.initListener()
    }

}