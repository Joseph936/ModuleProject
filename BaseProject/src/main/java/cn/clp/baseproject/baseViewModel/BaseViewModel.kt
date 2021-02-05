package cn.clp.baseproject.baseViewModel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.config.HttpConfig
import cn.clp.common.configs.AppConfig
import cn.clp.common.utils.Https.HttpUtil
import cn.clp.common.utils.Https.response.Callback
import cn.clp.common.utils.Https.response.HttpResponse
import cn.clp.common.utils.MMKVUtil

open abstract class BaseViewModel<V : ViewDataBinding> : BaseObservable(), BaseInterface, Callback {
    private var context: Context? = null
    private var viewDataBinding: V? = null

    fun registerViewModel(context: Context, viewDataBinding: V) {
        this.context = context
        this.viewDataBinding = viewDataBinding
        initView()
        initData()
    }

    override fun initView() {
    }

    override fun initData() {
        initListener()
    }

    override fun initListener() {
    }

    protected fun getContext(): Context? {
        return context
    }

    protected fun getViewDataBinding(): V? {
        return viewDataBinding
    }

    protected fun finish() {
        if (context.let { it is AppCompatActivity }) {
            var activity = context as AppCompatActivity
            activity.finish()
        }
    }


    fun <T : Any> startGetRequest(url: String, params: LinkedHashMap<String, String>, tag: String) {
        var stamp = System.currentTimeMillis() / 1000;
        var timeStamp = (stamp xor stamp / 1000000) * 2
        HttpUtil.newInstance().getRequest<T>(AppConfig.SCHEME_API + url)
                ?.addHeader(HttpConfig.HEAD_KEY_APP_CHANNEL, "")
                ?.addHeader(HttpConfig.HEAD_KEY_UID, MMKVUtil.getKVString(MMKVUtil.CURRENT_USER_ID, ""))
                ?.addHeader(HttpConfig.HEAD_KEY_AUTO_TOKEN, MMKVUtil.getKVString(MMKVUtil.AUTO_TOKEN, ""))
                ?.addHeader(HttpConfig.HEAD_KEY_TIMESTAMP, timeStamp.toString())
                ?.setRetryCount(0)
                ?.addUrlParam(params)
                ?.execute<T>(tag, this)
    }

    fun <T : Any> startPostRequest(url: String, params: LinkedHashMap<String, String>, tag: String) {
        var stamp = System.currentTimeMillis() / 1000;
        var timeStamp = (stamp xor stamp / 1000000) * 2
        HttpUtil.newInstance().postRequest<T>(AppConfig.SCHEME_API + url)
                ?.addHeader(HttpConfig.HEAD_KEY_APP_CHANNEL, "")
                ?.addHeader(HttpConfig.HEAD_KEY_UID, MMKVUtil.getKVString(MMKVUtil.CURRENT_USER_ID, ""))
                ?.addHeader(HttpConfig.HEAD_KEY_AUTO_TOKEN, MMKVUtil.getKVString(MMKVUtil.AUTO_TOKEN, ""))
                ?.addHeader(HttpConfig.HEAD_KEY_TIMESTAMP, timeStamp.toString())
                ?.setAddUrlFromParam(false)
                ?.setRetryCount(0)
                ?.addUrlParam(params)
                ?.execute<T>(tag, this)
    }

    override fun onStartRequest(flag: String) {
        when (flag) {
        }
    }

    override fun <T : Any> onSuccessRequest(flag: String, response: HttpResponse<T>) {
        when (flag) {
        }
    }

    override fun onErrorRequest(flag: String, hasNetWork: Boolean) {
        when (flag) {
        }
    }

}