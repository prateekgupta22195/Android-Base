package com.pg.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return getInflatedView(getLayoutId(),inflater,container)
    }

    private fun getInflatedView(layoutId: Int, inflater : LayoutInflater, container : ViewGroup?): View? {
        return inflater.inflate(layoutId, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewInflated(view,savedInstanceState)
    }


    open fun getScreenName(): String? {
        return this.javaClass.name
    }

    abstract fun onViewInflated(view: View, savedInstanceState: Bundle?)

    abstract fun getLayoutId() : Int


    protected open fun isSafe(): Boolean {
        return !(this.isRemoving || this.activity == null || this.isDetached || !this.isAdded || this.view == null)
    }



}