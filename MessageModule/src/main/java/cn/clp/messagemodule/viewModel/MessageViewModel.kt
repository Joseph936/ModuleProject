package cn.clp.messagemodule.viewModel

import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.messagemodule.databinding.FragmentMessageViewBinding

class MessageViewModel : BaseViewModel<FragmentMessageViewBinding>() {
    private var textContent = "消息页面"
    override fun initView() {
        super.initView()
        getViewDataBinding()!!.messageViewModel = this
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
        return textContent!!
    }
}