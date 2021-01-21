package cn.clp.moduleproject.viewModel

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomeViewPagerAdapter(context: Context, listFragment: ArrayList<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var listFragment = listFragment
    var context = context

    override fun getItem(position: Int): Fragment {
        return listFragment!![position]
    }

    override fun getCount(): Int {
        if (listFragment == null) return 0
        return listFragment!!.size
    }

}