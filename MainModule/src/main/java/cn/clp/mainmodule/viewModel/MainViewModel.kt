package cn.clp.mainmodule.viewModel

import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.mainmodule.databinding.FragmentMainViewBinding

class MainViewModel : BaseViewModel<FragmentMainViewBinding>() {
    private var textContent = "主页页面"
    override fun initView() {
        super.initView()
        getViewDataBinding()!!.mainViewModel = this
    }

    override fun initData() {
        super.initData()
    }

    override fun initListener() {
        super.initListener()
    }

    fun setTextContext(textContext: String) {
        this.textContent = textContent
    }

    fun getTextContent(): String {
        return textContent
    }

}