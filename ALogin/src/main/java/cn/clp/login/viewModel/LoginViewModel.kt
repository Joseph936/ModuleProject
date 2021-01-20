package cn.clp.login.viewModel

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.MMKVUtil
import cn.clp.common.utils.ToastUtil
import cn.clp.login.databinding.ActivityLoginBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV

class LoginViewModel : BaseViewModel<ActivityLoginBinding>() {
    override fun initData() {
        super.initData()
        getViewDataBinding()!!.let { it.edtAccount.setText(MMKVUtil.getKVString(MMKVUtil.USER_ACCOUNT)) }
    }

    //登录按钮点击
    fun loginOnclick(view: View) {
        var userAccount = getViewDataBinding()!!.edtAccount.text.toString().trim()
        var userPassword = getViewDataBinding()!!.edtPassword.text.toString().trim()

        if (TextUtils.isEmpty(userAccount)) {
            ToastUtil.ShowToast("请输入账号")
        } else if (TextUtils.isEmpty(userPassword)) {
            ToastUtil.ShowToast("请输入密码")
        } else {
            MMKVUtil.putKVString(MMKVUtil.USER_ACCOUNT, userAccount)
            MMKVUtil.putKVString(MMKVUtil.USER_PASSWORD, userPassword)
            ARouter.getInstance().build(ARouterConfig.HOME_ACTIVITY_PATH).navigation()
            MMKVUtil.putKVBoolean(MMKVUtil.LOGIN_STATUS, true)
            finish()
        }
    }

}