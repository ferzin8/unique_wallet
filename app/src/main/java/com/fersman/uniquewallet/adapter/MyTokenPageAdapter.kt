package com.fersman.uniquewallet.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fersman.uniquewallet.ui.home.CoinsFragment
import com.fersman.uniquewallet.ui.home.nfts.TokensListFragment

class MyTokensPagerAdapter(fragmentManager: FragmentManager?, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager!!, lifecycle) {

    private val fragmentList: ArrayList<Fragment> = ArrayList()

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TokensListFragment()
            1 -> CoinsFragment()
            else -> TokensListFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2//fragmentList.size
    }
}