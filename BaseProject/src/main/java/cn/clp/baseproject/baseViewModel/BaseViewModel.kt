package cn.clp.baseproject.baseViewModel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.BaseObservable
import androidx.databinding.ViewDataBinding

open abstract class BaseViewModel<V : ViewDataBinding> : BaseObservable(), BaseInterface {
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

    protected fun getContext(): Context {
        return context!!
    }

    protected fun getViewDataBinding(): V? {
        return viewDataBinding
    }

    protected fun finish() {
        if (context!!.let { it is AppCompatActivity }) {
            var activity = context as AppCompatActivity
            activity.finish()
        }
    }
}