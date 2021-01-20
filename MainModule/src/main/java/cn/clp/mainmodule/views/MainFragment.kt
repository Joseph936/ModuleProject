package cn.clp.mainmodule.views

import cn.clp.baseproject.baseView.BaseFragment
import cn.clp.mainmodule.R
import cn.clp.mainmodule.databinding.FragmentMainViewBinding
import cn.clp.mainmodule.viewModel.MainViewModel

class MainFragment : BaseFragment<FragmentMainViewBinding, MainViewModel>() {
    private var viewModel: MainViewModel? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_main_view
    }

    override fun getViewModel(): MainViewModel? {
        if (viewModel == null) viewModel = MainViewModel()
        return viewModel
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }

    override fun initListener() {
        super.initListener()
    }

}