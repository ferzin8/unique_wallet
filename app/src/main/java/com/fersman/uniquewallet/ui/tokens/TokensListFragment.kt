package com.fersman.uniquewallet.ui.tokens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.TokenItemObject
import com.fersman.uniquewallet.adapter.TokenItemAdapter
import com.fersman.uniquewallet.ui.home.MyTokensFragment

class TokensListFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var root: ViewGroup
    private var itemsList: ArrayList<TokenItemObject> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        root = inflater.inflate(R.layout.fragment_tokens, container, false) as ViewGroup
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = root.findViewById(R.id.recycle_token_view)

        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        for (i in 0 until 10) {
            itemsList.add(TokenItemObject())
        }

        val listAdapter = TokenItemAdapter(itemsList)
        recyclerView.adapter = listAdapter
    }
}