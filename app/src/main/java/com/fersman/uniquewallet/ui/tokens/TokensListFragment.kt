package com.fersman.uniquewallet.ui.tokens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.fersman.uniquewallet.R
import com.fersman.uniquewallet.ui.home.MyTokensFragment

class TokensListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_tokens, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(MyTokensFragment.ARG_OBJECT) }?.apply {

        }
    }
}