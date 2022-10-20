package com.fersman.uniquewallet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.TokenItemObject
import com.fersman.uniquewallet.ui.view.TokenItemInListView

class TokenItemAdapter(private val tokenItems: List<TokenItemObject>): RecyclerView.Adapter<TokenItemAdapter.ViewHolder>() {

    class ViewHolder(tokenItemInListView: TokenItemInListView) : RecyclerView.ViewHolder(tokenItemInListView) {
        var view: TokenItemInListView

        init {
            view = tokenItemInListView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.token_item_view, parent, false) as TokenItemInListView

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.view.init(tokenItems[position])
    }

    override fun getItemCount(): Int {
        return tokenItems.size
    }
}