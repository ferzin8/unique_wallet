package com.fersman.uniquewallet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.CoinObject
import com.fersman.uniquewallet.ui.view.CoinItemView

class CoinItemAdapter (private val coinItems: List<CoinObject>): RecyclerView.Adapter<CoinItemAdapter.ViewHolder>() {

    class ViewHolder(coinItemView: CoinItemView) : RecyclerView.ViewHolder(coinItemView) {
        var view: CoinItemView

        init {
            view = coinItemView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_coin_item, parent, false) as CoinItemView

        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.view.init(coinItems[position])
    }

    override fun getItemCount(): Int {
        return coinItems.size
    }
}