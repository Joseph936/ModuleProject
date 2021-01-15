package cn.clp.moduleproject.views

import android.content.Context
import android.content.Intent
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.moduleproject.R

class HomeActivity : BaseActivity() {
    companion object {
        fun startHomeActivity(context: Context) {
            var intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }
}