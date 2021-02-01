package cn.clp.login.viewModel

import android.os.Handler
import android.os.Message
import android.view.View
import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.ActivityLifeUtil
import cn.clp.common.utils.MMKVUtil
import cn.clp.login.R
import cn.clp.login.databinding.ActivitySplashBinding
import cn.clp.login.views.LoginActivity
import com.alibaba.android.arouter.launcher.ARouter

class SplashViewModel : BaseViewModel<ActivitySplashBinding>() {
    private var countDown = 5
    private var handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            countDown--
            getViewDataBinding()?.tvCountDown?.text = getContext()?.getString(R.string.splash_count_down)?.let { String.format(it, countDown) }
            if (countDown == 0) {
                showCountDownView(false)
            } else {
                sendEmptyMessageDelayed(0, 1000)
            }
        }
    }

    override fun initView() {
        super.initView()
        getViewDataBinding()?.splashViewModel = this
    }

    override fun initData() {
        super.initData()
        if (ActivityLifeUtil.newInstance().getActiveActivityCount() > 1) {
            finish()
        } else {
            showCountDownView(true)
        }
    }

    override fun initListener() {
        super.initListener()
    }

    private fun showCountDownView(isShow: Boolean) {
        if (isShow) {
            getViewDataBinding()?.tvCountDown?.visibility = View.VISIBLE
            getViewDataBinding()?.tvCountDown?.text = getContext()?.getString(R.string.splash_count_down)?.let { String.format(it, countDown) }
            handler.removeCallbacksAndMessages(null)
            handler.sendEmptyMessageDelayed(0, 1000)
        } else {
            handler.removeCallbacksAndMessages(null)
            getViewDataBinding()?.tvCountDown?.visibility = View.GONE
            goToHomeActivity()
        }

    }

    fun closeCountDown(view: View) {
        if (ActivityLifeUtil.newInstance().isAppInBackground()) {
            finish()
        } else {
            showCountDownView(false)
        }
    }


    /**
     * 跳转到home 页
     */
    private fun goToHomeActivity() {
        var isLogin: Boolean = MMKVUtil.getKVBoolean(MMKVUtil.LOGIN_STATUS)
//        if (isLogin) {
//            ARouter.getInstance().build(ARouterConfig.HOME_ACTIVITY_PATH).navigation()
//            finish()
//        } else {
        getContext()?.let { LoginActivity.startLoginActivity(it) }
        finish()
//        }
    }

}
