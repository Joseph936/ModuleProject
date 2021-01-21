package cn.clp.moduleproject.viewModel

import cn.clp.baseproject.baseViewModel.BaseViewModel
import cn.clp.moduleproject.databinding.ActivityHomeBinding

class HomeViewModel : BaseViewModel<ActivityHomeBinding>() {
    override fun initView() {
        super.initView()
        getViewDataBinding()!!.homeViewModel=this
    }

    override fun initData() {
        super.initData()
    }
}