package cn.clp.baseproject.baseViewModel

import android.content.Context
import androidx.databinding.BaseObservable
import cn.clp.baseproject.databinding.LayoutBaseViewBinding

open class BaseViewModel : BaseObservable() {
    lateinit var baseViewBinding: LayoutBaseViewBinding
    lateinit var context: Context

    fun registerBaseViewModel(context: Context, baseViewBinding: LayoutBaseViewBinding) {
        this.context = context
        this.baseViewBinding = baseViewBinding
        baseViewBinding.baseViewModel = this
    }

    open fun initData() {}
}