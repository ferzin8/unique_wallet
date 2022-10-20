package com.fersman.uniquewallet.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fersman.uniquewallet.ui.home.MyTokensFragment
import com.fersman.uniquewallet.ui.tokens.TokensListFragment

class MyTokensPagerAdapter(fragmentManager: FragmentManager?, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager!!, lifecycle) {

    private val fragmentList: ArrayList<Fragment> = ArrayList()

    override fun createFragment(position: Int): Fragment {
        val fragment = TokensListFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(MyTokensFragment.ARG_OBJECT, position + 1)
        }
        fragmentList.add(fragment)

        return fragment
    }

    override fun getItemCount(): Int {
        return 2//fragmentList.size
    }
}