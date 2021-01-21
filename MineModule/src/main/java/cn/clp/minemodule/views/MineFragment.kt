package cn.clp.minemodule.views

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.baseView.BaseFragment
import cn.clp.minemodule.R
import cn.clp.minemodule.databinding.FragmentMineViewBinding
import cn.clp.minemodule.viewModel.MineViewModel

class MineFragment : BaseFragment<FragmentMineViewBinding, MineViewModel>() {
    private var viewModel:MineViewModel?=null

    companion object {
        fun newInstance(): MineFragment {
            var fragment = MineFragment()
            var bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine_view
    }

    override fun getViewModel(): MineViewModel? {
        if (viewModel==null)viewModel= MineViewModel()
        return viewModel
    }


}