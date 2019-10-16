package com.flores.coroutinessampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 10/13/2019
 */
class MainActivity : AppCompatActivity(), View {

    override fun showData(text: String) {
        Log.e("error", text)
    }

    var mainViewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainButton.setOnClickListener {
            mainViewModel.execute()
        }
    }


    override fun onDestroy() {
        mainViewModel.deleteJob()
        super.onDestroy()
    }
}
