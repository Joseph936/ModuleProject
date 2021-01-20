package cn.clp.moduleproject.views

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.fragment.app.Fragment
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.baseproject.baseView.BaseFragment
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.ToastUtil
import cn.clp.moduleproject.R
import cn.clp.moduleproject.databinding.ActivityHomeBinding
import cn.clp.moduleproject.viewModel.HomeViewModel
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView

@Route(path = ARouterConfig.HOME_ACTIVITY_PATH)
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener {
    private var viewModel: HomeViewModel? = null
    private var listFragment: List<Fragment>? = null

    companion object {
        fun startHomeActivity(context: Context) {
            var intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun getViewModel(): HomeViewModel? {
        if (viewModel == null) {
            viewModel = HomeViewModel()
        }
        return viewModel
    }

    override fun initView() {
        super.initView()
        getViewDataBinding()!!.bottomNavigation.itemIconTintList = null
    }

    override fun initData() {
        super.initData()
        if (listFragment == null) listFragment = ArrayList()
//        var
    }

    override fun initListener() {
        super.initListener()
        getViewDataBinding()!!.bottomNavigation.setOnNavigationItemSelectedListener(this)
        getViewDataBinding()!!.bottomNavigation.setOnNavigationItemReselectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_bottom_home -> {
                ToastUtil.ShowToast("首页")
            }
            R.id.item_bottom_message -> {
                ToastUtil.ShowToast("消息")
            }
            R.id.item_bottom_mine -> {
                ToastUtil.ShowToast("我的")
            }
        }
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        when (item.itemId) {
            R.id.item_bottom_home -> {
                ToastUtil.ShowToast("再次点击-首页")
            }
            R.id.item_bottom_message -> {
                ToastUtil.ShowToast("再次点击-消息")
            }
            R.id.item_bottom_mine -> {
                ToastUtil.ShowToast("再次点击-我的")
            }
        }
    }
}