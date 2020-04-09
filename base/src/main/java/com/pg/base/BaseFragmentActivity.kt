package com.pg.base

import androidx.fragment.app.Fragment

abstract class BaseFragmentActivity : BaseActivity() {

    abstract fun getFragmentContainerViewId() : Int


    fun inflateReplaceFragment(addToBackStack: Boolean, backStackTag: String, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        if (addToBackStack)
            transaction.replace(getFragmentContainerViewId(), fragment).addToBackStack(backStackTag).commit()
        else
            transaction.replace(getFragmentContainerViewId(), fragment).commit()
    }


    fun inflateAddFragment(addToBackStack: Boolean, backStackTag: String, fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        if (addToBackStack)
            fragmentManager.beginTransaction().add(getFragmentContainerViewId(), fragment).addToBackStack(backStackTag).commit()
        else
            fragmentManager.beginTransaction().add(getFragmentContainerViewId(), fragment).commit()
    }

}