package cn.clp.baseproject.baseView

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.baseViewModel.BaseInterface
import cn.clp.baseproject.baseViewModel.BaseViewModel

abstract class BaseActivity<V : ViewDataBinding, T : BaseViewModel<V>> : AppCompatActivity(), BaseInterface {
    private var viewDataBingDing: V? = null
    private var viewModel: T? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBingDing = DataBindingUtil.setContentView(this, getLayoutId())
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int;

    override fun initView() {
    }

    override fun initData() {
        viewModel = getViewModel()
        viewDataBingDing!!.let { viewModel!!.registerViewModel(this, it) }
    }

    open abstract fun getViewModel(): T?

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }


    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
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

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}