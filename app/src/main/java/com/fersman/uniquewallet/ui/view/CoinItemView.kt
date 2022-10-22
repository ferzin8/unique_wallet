package com.fersman.uniquewallet.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.`object`.CoinObject

class CoinItemView (context: Context, attributeSet: AttributeSet) : ConstraintLayout(context, attributeSet) {
    private lateinit var netImage: ImageView
    private lateinit var netName: TextView
    private lateinit var address: TextView
    private lateinit var balance: TextView
    private lateinit var transferable: TextView
    private lateinit var locked: TextView

    fun init (coinObject: CoinObject) {
        netImage = findViewById(R.id.net_cover)
        netImage.background = ResourcesCompat.getDrawable(resources, R.drawable.kusama, null)

        netName = findViewById(R.id.net_name)
        netName.text = coinObject.netName

        address = findViewById(R.id.user_address)
        address.text = coinObject.walletAddress

        balance = findViewById(R.id.net_balance)
        balance.text = coinObject.userBalance

        transferable = findViewById(R.id.transferable)
        transferable.text = coinObject.transferable

        locked = findViewById(R.id.locked)
        locked.text = coinObject.locked
    }
}