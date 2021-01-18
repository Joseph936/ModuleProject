package cn.clp.baseproject.baseViewModel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.BaseObservable
import androidx.databinding.ViewDataBinding

open abstract class BaseViewModel<V : ViewDataBinding> : BaseObservable() {
    protected var context: Context? = null
    private var viewDataBinding: V? = null
    open fun initData() {}

    open fun registerViewModel(context: Context, viewDataBinding: V) {
        this.context = context
        this.viewDataBinding = viewDataBinding
    }

    fun finish() {
        if (context!!.let { it is AppCompatActivity }) {
            var activity = context as AppCompatActivity
            activity.finish()
        }
    }
}