package cn.clp.moduleproject.views

import android.content.Context
import android.content.Intent
import cn.clp.baseproject.baseView.BaseActivity
import cn.clp.baseproject.config.ARouterConfig
import cn.clp.moduleproject.R
import cn.clp.moduleproject.databinding.ActivityHomeBinding
import cn.clp.moduleproject.viewModel.HomeViewModel
import com.alibaba.android.arouter.facade.annotation.Route

@Route(path = ARouterConfig.HOME_ACTIVITY_PATH)
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    companion object {
        fun startHomeActivity(context: Context) {
            var intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    private var homeViewModel: HomeViewModel? = null
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun getViewModel(): HomeViewModel? {
        homeViewModel = HomeViewModel()
        return homeViewModel
    }

}