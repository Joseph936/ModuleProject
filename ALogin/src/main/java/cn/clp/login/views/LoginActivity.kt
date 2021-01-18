package cn.clp.login.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.login.R
import cn.clp.login.databinding.ActivityLoginBinding
import cn.clp.login.viewModel.LoginViewModel
import cn.clp.common.utils.MMKVUtil.Companion as MMKVUtil1

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
        loginViewModel = LoginViewModel()
        return loginViewModel
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
        loginViewModel!!.let { it.initData() }
    }

    /**
     * 清楚登录信息
     */
    private fun clearLoginStatus() {
        MMKVUtil1.putKVBoolean(MMKVUtil1.LOGIN_STATUS, false)
        MMKVUtil1.putKVString(MMKVUtil1.USER_PASSWORD, "")
    }
}