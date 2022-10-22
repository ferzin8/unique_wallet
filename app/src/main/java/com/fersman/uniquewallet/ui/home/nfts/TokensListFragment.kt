package com.fersman.uniquewallet.ui.home.nfts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.TokenItemObject
import com.fersman.uniquewallet.adapter.TokenItemAdapter
import com.fersman.uniquewallet.databinding.FragmentHomeBinding
import com.fersman.uniquewallet.databinding.FragmentTokensBinding

class TokensListFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var itemsList: ArrayList<TokenItemObject> = ArrayList()

    private var _binding: FragmentTokensBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tokensListViewModel =
            ViewModelProvider(this).get(TokensListViewModel::class.java)

        _binding = FragmentTokensBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recycleTokenView

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        for (i in 0 until 3) {
            itemsList.add(TokenItemObject())
        }

        val listAdapter = TokenItemAdapter(itemsList)
        recyclerView.adapter = listAdapter
    }
}