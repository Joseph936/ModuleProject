package cn.clp.mainmodule.views

import android.os.Bundle
import cn.clp.baseproject.baseView.BaseFragment
import cn.clp.mainmodule.R
import cn.clp.mainmodule.databinding.FragmentMainViewBinding
import cn.clp.mainmodule.viewModel.MainViewModel

class MainFragment : BaseFragment<FragmentMainViewBinding, MainViewModel>() {
    private var viewModel: MainViewModel? = null
    private var callBack: MainFragmentCallBack? = null

    companion object {
//        fun newInstance(callBack: MainFragmentCallBack): MainFragment {
        fun newInstance(): MainFragment {
            var fragment = MainFragment()
            var bundle = Bundle()
            fragment.arguments = bundle
//            fragment.addCallBack(callBack)
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_main_view
    }

    override fun getViewModel(): MainViewModel? {
        if (viewModel == null) viewModel = MainViewModel()
        return viewModel
    }

    private fun addCallBack(callBack: MainFragmentCallBack) {
        this.callBack = callBack
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

    class MainFragmentCallBack {
    }
}