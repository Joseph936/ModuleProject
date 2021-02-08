package cn.clp.login.viewModel

import android.text.TextUtils
import android.view.View
import cn.clp.baseproject.baseModel.NetConfigFlag
import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.baseproject.utils.AppUtil
import cn.clp.common.configs.AppConfig
import cn.clp.common.utils.Https.model.HttpResponse
import cn.clp.common.utils.Https.model.HttpResponseEmpty
import cn.clp.common.utils.MMKVUtil
import cn.clp.common.utils.ToastUtil
import cn.clp.login.databinding.ActivityLoginBinding
import com.alibaba.android.arouter.launcher.ARouter

class LoginViewModel : BaseViewModel<ActivityLoginBinding>() {
    override fun initView() {
        super.initView()
        getViewDataBinding()?.loginViewModel = this
    }

    override fun initData() {
        super.initData()
        getViewDataBinding()?.let { it.edtMobile.setText(MMKVUtil.getKVString(MMKVUtil.USER_ACCOUNT,"")) }
    }

    //登录按钮点击
    fun loginOnclick(view: View) {
        var mobile = getViewDataBinding()?.edtMobile?.text.toString().trim()
        var mobileSign = getViewDataBinding()?.edtSignCode?.text.toString().trim()

        if (TextUtils.isEmpty(mobile)) {
            ToastUtil.showToast("请输入账号")
//        } else if (TextUtils.isEmpty(mobileSign)) {
//            ToastUtil.showToast("请输入验证码")
        } else {
            var sign = AppUtil.createMd5Code(mobile)
            var param = LinkedHashMap<String, String>()
            param["mobile"] = mobile
            param["sign"] = sign.toString()
            startPostRequest<HttpResponse<HttpResponseEmpty>>(AppConfig.LOGIN_API, param, NetConfigFlag.LOGIN_CODE)
            MMKVUtil.putKVString(MMKVUtil.USER_ACCOUNT, mobile)
        }
    }

    override fun onStartRequest(flag: String) {
        super.onStartRequest(flag)
        when (flag) {
            NetConfigFlag.LOGIN_CODE -> {
                NetConfigFlag.LOGIN_CODE
            }
        }
    }

    override fun <T:Any> onSuccessRequest(flag: String, response: HttpResponse<T>) {
        super.onSuccessRequest(flag, response)
        when (flag) {
            NetConfigFlag.LOGIN_CODE -> {
                ARouter.getInstance().build(ARouterConfig.HOME_ACTIVITY_PATH).navigation()
                MMKVUtil.putKVBoolean(MMKVUtil.LOGIN_STATUS, true)
                finish()
                NetConfigFlag.LOGIN_CODE
            }
        }
    }

    override fun onErrorRequest(flag: String, hasNetWork: Boolean) {
        super.onErrorRequest(flag, hasNetWork)
        when (flag) {
            NetConfigFlag.LOGIN_CODE ->
                NetConfigFlag.LOGIN_CODE
        }
    }


}