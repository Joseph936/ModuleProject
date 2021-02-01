package cn.clp.moduleproject.views

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.common.utils.ToastUtil
import cn.clp.mainmodule.views.MainFragment
import cn.clp.messagemodule.views.MessageFragment
import cn.clp.minemodule.views.MineFragment
import cn.clp.moduleproject.R
import cn.clp.moduleproject.databinding.ActivityHomeBinding
import cn.clp.moduleproject.viewModel.HomeViewModel
import cn.clp.moduleproject.viewModel.HomeViewPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.bottomnavigation.BottomNavigationView

@Route(path = ARouterConfig.HOME_ACTIVITY_PATH)
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>(), BottomNavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemReselectedListener, ViewPager.OnPageChangeListener {
    private var viewModel: HomeViewModel? = null
    private var listFragment: ArrayList<Fragment>? = null
    private var adapter: HomeViewPagerAdapter? = null

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
        initFragmentList()
        iniViewPager()
    }

    override fun initListener() {
        super.initListener()
        getViewDataBinding()!!.bottomNavigation.setOnNavigationItemSelectedListener(this)
        getViewDataBinding()!!.bottomNavigation.setOnNavigationItemReselectedListener(this)
        getViewDataBinding()!!.bottomViewpager.addOnPageChangeListener(this)
    }

    private fun initFragmentList() {
        if (listFragment == null) listFragment = ArrayList<Fragment>()
        var mainFragment = MainFragment.newInstance()
        listFragment!!.add(mainFragment)
        var messageFragment = MessageFragment.newInstance()
        listFragment!!.add(messageFragment)
        var mineFragment = MineFragment.newInstance()
        listFragment!!.add(mineFragment)
    }

    private fun iniViewPager() {
        adapter = HomeViewPagerAdapter(this, listFragment!!, supportFragmentManager);
        getViewDataBinding()!!.bottomViewpager.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_bottom_home -> {
                getViewDataBinding()!!.bottomViewpager.currentItem = 0
            }
            R.id.item_bottom_message -> {
                getViewDataBinding()!!.bottomViewpager.currentItem = 1
            }
            R.id.item_bottom_mine -> {
                getViewDataBinding()!!.bottomViewpager.currentItem = 2
            }
        }
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        when (item.itemId) {
            R.id.item_bottom_home -> {
                ToastUtil.showToast("再次点击-首页")
            }
            R.id.item_bottom_message -> {
                ToastUtil.showToast("再次点击-消息")
            }
            R.id.item_bottom_mine -> {
                ToastUtil.showToast("再次点击-我的")
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        var menu = getViewDataBinding()!!.bottomNavigation.menu.getItem(position)
        menu.isChecked = true
    }
}