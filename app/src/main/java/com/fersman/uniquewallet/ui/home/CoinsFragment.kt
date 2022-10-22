package com.fersman.uniquewallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.CoinObject
import com.fersman.uniquewallet.`object`.TokenItemObject
import com.fersman.uniquewallet.adapter.CoinItemAdapter
import com.fersman.uniquewallet.adapter.TokenItemAdapter

class CoinsFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var root: ViewGroup
    private var itemsList: ArrayList<CoinObject> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_coins, container, false) as ViewGroup
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = root as RecyclerView

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        for (i in 0 until 3) {
            itemsList.add(CoinObject())
        }

        val listAdapter = CoinItemAdapter(itemsList)
        recyclerView.adapter = listAdapter
    }
}