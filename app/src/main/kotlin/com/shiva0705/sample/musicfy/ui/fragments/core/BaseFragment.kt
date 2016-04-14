package com.shiva0705.sample.musicfy.ui.fragments.core

import android.app.Fragment
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment(){

    open val viewId : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(viewId, container, false);
    }

    fun handleNetworkError(ex : Throwable, listener : View.OnClickListener){
        Snackbar.make(activity.findViewById(android.R.id.content), ex.message.toString(), Snackbar.LENGTH_LONG)
                .setAction("Try again", listener)
                .setActionTextColor(Color.RED)
                .show();
    }

}