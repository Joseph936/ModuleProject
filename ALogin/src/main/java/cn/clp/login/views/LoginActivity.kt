package cn.clp.login.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.login.Product2Consumer
import cn.clp.login.R
import cn.clp.login.databinding.ActivityLoginBinding
import cn.clp.login.viewModel.LoginViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import cn.clp.common.utils.MMKVUtil.Companion as MMKVUtil1

@Route(path = ARouterConfig.LOGIN_ACTIVITY_PATH)
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    companion object {
        fun startLoginActivity(context: Context) {
            var intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var loginViewModel: LoginViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clearLoginStatus()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): LoginViewModel? {
        if (loginViewModel == null) {
            loginViewModel = LoginViewModel()
        }
        return loginViewModel
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()

        var model = Product2Consumer()
        var productThread1=Product2Consumer.Producer(model)
        var productThread2=Product2Consumer.Producer(model)
        var consumerThread=Product2Consumer.Consumer(model)

        productThread1.start()
        productThread2.start()
        consumerThread.start()

    }

    /**
     * 清楚登录信息
     */
    private fun clearLoginStatus() {
        MMKVUtil1.putKVBoolean(MMKVUtil1.LOGIN_STATUS, false)
        MMKVUtil1.putKVString(MMKVUtil1.USER_PASSWORD, "")
    }
}