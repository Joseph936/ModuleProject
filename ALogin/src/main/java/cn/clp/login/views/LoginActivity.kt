package cn.clp.login.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.login.R
import cn.clp.login.databinding.ActivityLoginBinding
import cn.clp.login.viewModel.LoginViewModel
import cn.clp.common.utils.MMKVUtil.Companion as MMKVUtil1

class LoginActivity : BaseActivity() {
    companion object {
        fun startLoginActivity(context: Context) {
            var intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clearLoginStatus()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        super.initView()
        loginBinding = childViewBinding as ActivityLoginBinding
    }

    override fun initData() {
        super.initData()
        loginViewModel = LoginViewModel()
        loginViewModel.registerViewModel(loginBinding)
    }

    /**
     * 清楚登录信息
     */
    private fun clearLoginStatus() {
        MMKVUtil1.putKVBoolean(MMKVUtil1.LOGIN_STATUS, false)
        MMKVUtil1.putKVString(MMKVUtil1.USER_PASSWORD, "")
    }
}