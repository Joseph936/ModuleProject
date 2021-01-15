package cn.clp.login.viewModel

import android.text.TextUtils
import android.view.View
import android.widget.Toast
import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.common.utils.MMKVUtil
import cn.clp.common.utils.ToastUtil
import cn.clp.login.databinding.ActivityLoginBinding

class LoginViewModel : BaseViewModel() {
    private lateinit var loginBinding: ActivityLoginBinding
    fun registerViewModel(loginBinding: ActivityLoginBinding) {
        this.loginBinding = loginBinding
        loginBinding.loginViewModel = this
    }

    override fun initData() {
        super.initData()
        loginBinding.edtAccount.setText(MMKVUtil.getKVString(MMKVUtil.USER_ACCOUNT))
    }

    fun loginOnclick(view: View) {
        var userAccount = loginBinding.edtAccount.text.toString().trim()
        var userPassword = loginBinding.edtPassword.text.toString().trim()

        if (TextUtils.isEmpty(userAccount)) {
            ToastUtil.ShowToast("请输入账号")
        } else if (TextUtils.isEmpty(userPassword)) {
            ToastUtil.ShowToast("请输入密码")
        } else {

        }
    }
}