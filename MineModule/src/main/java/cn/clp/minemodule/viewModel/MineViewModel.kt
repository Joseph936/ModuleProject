package cn.clp.minemodule.viewModel

import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.minemodule.databinding.FragmentMineViewBinding

class MineViewModel : BaseViewModel<FragmentMineViewBinding>() {
    private var textContent = "我的页面"
    override fun initView() {
        super.initView()
        getViewDataBinding()!!.mineViewModel = this
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