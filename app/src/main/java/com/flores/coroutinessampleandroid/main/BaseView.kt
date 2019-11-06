package com.flores.coroutinessampleandroid.main

import com.flores.coroutinessampleandroid.model.User

/**
 * BaseView
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 10/13/2019
 */
interface BaseView {

    fun showData(text: String)
    fun showUser(user: User)
    fun showLoader()
    fun hideLoader()

}