package cn.clp.baseproject.baseViewModel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BaseObservable
import androidx.databinding.ViewDataBinding
import cn.clp.common.utils.Https.HttpUtil
import cn.clp.common.utils.Https.response.Callback
import cn.clp.common.utils.Https.response.HttpResponse

open abstract class BaseViewModel<V : ViewDataBinding> : BaseObservable(), BaseInterface, Callback<Any> {
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

    fun <T> startGetRequest(params: LinkedHashMap<String, String>, url: String, flag: String) {
        HttpUtil.newInstance().getRequest<HttpResponse<T>>(url, params).execute(flag, this)
    }

    override fun onStartRequest(flag: String) {
        when (flag) {
        }
    }

    override fun onSuccessRequest(flag: String, response: HttpResponse<Any>) {
        when (flag) {
        }
    }

    override fun onErrorRequest(flag: String, hasNetWork: Boolean) {
        when (flag) {
        }
    }

}