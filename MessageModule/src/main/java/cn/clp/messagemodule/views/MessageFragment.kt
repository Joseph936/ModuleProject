package cn.clp.messagemodule.views

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.baseView.BaseFragment
import cn.clp.messagemodule.R
import cn.clp.messagemodule.databinding.FragmentMessageViewBinding
import cn.clp.messagemodule.viewModel.MessageViewModel

class MessageFragment : BaseFragment<FragmentMessageViewBinding, MessageViewModel>() {
    private var viewModel: MessageViewModel? = null

    companion object {
        fun newInstance(): MessageFragment {
            var fragment = MessageFragment()
            var bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_message_view
    }

    override fun getViewModel(): MessageViewModel? {
        if (viewModel == null) viewModel = MessageViewModel()
        return viewModel
    }

}