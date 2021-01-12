package cn.clp.baseproject.baseView

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import cn.clp.baseproject.R
import cn.clp.baseproject.baseModel.BaseInterface
import cn.clp.baseproject.databinding.ActivityBaseBinding
import kotlinx.android.synthetic.main.activity_base.view.*

abstract class BaseActivity : AppCompatActivity(), BaseInterface {
    private lateinit var baseViewBinding: ActivityBaseBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_base)
        setChildContentView(this, getLayoutId())
        initView()
        initData()
    }

    private fun setChildContentView(context: Context, layoutId: Int) {
        var childViewDataBinding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this.baseViewBinding.viewContent, false)
        var childView: View = childViewDataBinding.root;
        var lp: ViewGroup.LayoutParams = childView.layoutParams
        lp.height = ViewGroup.LayoutParams.MATCH_PARENT
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT
        childView.layoutParams = lp
        baseViewBinding.viewContent.addView(childView)
    }

    protected abstract fun getLayoutId(): Int;

    open fun showTitleView(): Boolean {
        return false
    }

    override fun initView() {
        if (showTitleView()) baseViewBinding.topTitleView.root.visibility = View.VISIBLE
        else baseViewBinding.topTitleView.root.visibility = View.GONE
    }

    override fun initData() {
    }

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