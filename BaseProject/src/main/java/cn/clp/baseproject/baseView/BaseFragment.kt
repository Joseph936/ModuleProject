package cn.clp.baseproject.baseView

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import cn.clp.baseproject.baseViewModel.BaseInterface
import cn.clp.baseproject.baseViewModel.BaseViewModel

abstract class BaseFragment<V : ViewDataBinding, T : BaseViewModel<V>> : Fragment(), BaseInterface {
    private var viewDataBingDing: V? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBingDing = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return viewDataBingDing!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int

    protected fun getViewDataBinding(): V? {
        return viewDataBingDing
    }

    abstract fun getViewModel(): T?

    override fun initView() {
        viewDataBingDing!!.let {
            getViewModel()!!.registerViewModel(context!!, it)
        }
    }

    override fun initData() {
        initListener()
    }

    override fun initListener() {
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }


}