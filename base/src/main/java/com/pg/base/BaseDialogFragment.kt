package com.pg.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment

abstract class BaseDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(getDialogViewResId(), null)
        onViewInflated(view, savedInstanceState)
        val dialog = Dialog(context!!)
        val params: ViewGroup.LayoutParams = dialog.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = params as WindowManager.LayoutParams
        dialog.setContentView(view)
        return dialog
    }

    abstract fun getDialogViewResId() : Int

    abstract fun onViewInflated(view: View, savedInstanceState: Bundle?)

}