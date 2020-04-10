package com.pg.base

import androidx.fragment.app.Fragment

abstract class BaseFragmentActivity : BaseActivity() {


    fun inflateReplaceFragment(addToBackStack: Boolean, backStackTag: String, fragment: Fragment, fragmentContainerViewId : Int) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        if (addToBackStack)
            transaction.replace(fragmentContainerViewId, fragment).addToBackStack(backStackTag).commit()
        else
            transaction.replace(fragmentContainerViewId, fragment).commit()
    }


    fun inflateAddFragment(addToBackStack: Boolean, backStackTag: String, fragment: Fragment, fragmentContainerViewId : Int) {
        val fragmentManager = supportFragmentManager
        if (addToBackStack)
            fragmentManager.beginTransaction().add(fragmentContainerViewId, fragment).addToBackStack(backStackTag).commit()
        else
            fragmentManager.beginTransaction().add(fragmentContainerViewId, fragment).commit()
    }

}