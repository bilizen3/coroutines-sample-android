package com.flores.coroutinessampleandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

/**
 * MainActivity
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 10/13/2019
 */
class MainActivity : AppCompatActivity(), View {

    override fun showData(text: String) {
        Timber.e(text)
    }

    private var mainViewModel = MainViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivity_btn.setOnClickListener {
            mainViewModel.execute()
        }
    }

    override fun showLoader() {
        mainActivity_pb.visibility = android.view.View.VISIBLE
    }

    override fun hideLoader() {
        mainActivity_pb.visibility = android.view.View.GONE
    }

    override fun onDestroy() {
        mainViewModel.deleteJob()
        super.onDestroy()
    }
}
