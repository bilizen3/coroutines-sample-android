package com.flores.coroutinessampleandroid

interface View {
    fun showData(text: String)
    fun showLoader()
    fun hideLoader()
}