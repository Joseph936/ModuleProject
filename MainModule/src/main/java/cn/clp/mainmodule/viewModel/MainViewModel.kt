package cn.clp.mainmodule.viewModel

import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.mainmodule.databinding.FragmentMainViewBinding

class MainViewModel : BaseViewModel<FragmentMainViewBinding>() {
        private var textContent: String? = null
    override fun initView() {
        super.initView()
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