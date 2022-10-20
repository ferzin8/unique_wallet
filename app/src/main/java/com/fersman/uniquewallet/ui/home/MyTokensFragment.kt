package com.fersman.uniquewallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.fersman.uniquewallet.databinding.FragmentHomeBinding
import com.fersman.uniquewallet.ui.tokens.TokensListFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MyTokensFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var myTokensPagerAdapter: MyTokensPagerAdapter
    private lateinit var viewPager: ViewPager2

    private lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myTokensViewModel =
            ViewModelProvider(this).get(MyTokensViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHomeTitle
        myTokensViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        myTokensPagerAdapter = MyTokensPagerAdapter(childFragmentManager, lifecycle)
        viewPager = binding.viewPager
        viewPager.adapter = myTokensPagerAdapter

        tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (position == 0) {
                tab.text = "NFTs"
            } else {
                tab.text = "Coins"
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class MyTokensPagerAdapter(fragmentManager: FragmentManager?, lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager!!, lifecycle) {

        private val fragmentList: ArrayList<Fragment> = ArrayList()

        override fun createFragment(position: Int): Fragment {
            val fragment = TokensListFragment()
            fragment.arguments = Bundle().apply {
                // Our object is just an integer :-P
                putInt(ARG_OBJECT, position + 1)
            }
            fragmentList.add(fragment)

            return fragment
        }

        override fun getItemCount(): Int {
            return 2//fragmentList.size
        }
    }

    companion object {
        const val ARG_OBJECT = "object"
    }
}

