package com.fersman.uniquewallet.ui.home.mytokens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.MarginLayoutParamsCompat
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.adapter.MyTokensPagerAdapter
import com.fersman.uniquewallet.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
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
        super.onViewCreated(view, savedInstanceState)
        myTokensPagerAdapter = MyTokensPagerAdapter(childFragmentManager, lifecycle)
        viewPager = binding.viewPager
        viewPager.adapter = myTokensPagerAdapter

        tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (position == 0) {
                tab.text = "NFTs"
                tab.id = 0
            } else {
                tab.text = "Coins"
                tab.id = 1
            }
        }.attach()

        viewPager.setPageTransformer { page, _ ->
            updatePagerHeightForChild(page, viewPager)
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.id) {
                    0 -> {
                        binding.filterAndSort.visibility = View.VISIBLE
                        val params = binding.nestScrollview.layoutParams as ViewGroup.MarginLayoutParams
                        params.bottomMargin = resources.getDimension(R.dimen.bottom_margin).toInt()
                    }
                    1 -> {
                        binding.filterAndSort.visibility = View.GONE
                        val params = binding.nestScrollview.layoutParams as ViewGroup.MarginLayoutParams
                        params.bottomMargin = resources.getDimension(R.dimen.activity_vertical_margin).toInt()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun updatePagerHeightForChild(view: View, pager: ViewPager2) {
        view.post {
            val wMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
            val hMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            view.measure(wMeasureSpec, hMeasureSpec)
            pager.layoutParams = (pager.layoutParams).also { lp -> lp.height = view.measuredHeight }
            pager.invalidate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



