package com.flores.coroutinessampleandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.flores.coroutinessampleandroid.MainViewModel
import com.flores.coroutinessampleandroid.R
import com.flores.coroutinessampleandroid.model.User
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * MainActivity
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 10/13/2019
 */
class MainActivity : AppCompatActivity(), BaseView {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivity_btn_save.setOnClickListener {
            mainViewModel.insertData("bill", "720333")
        }

        mainActivity_btn_get.setOnClickListener {
            if (mainActivity_et.text.toString().isNotEmpty()) {
                showLoader()
                mainViewModel.getUser(Integer.parseInt(mainActivity_et.text.toString()))
            }
        }
        mainViewModel.userLiveData.observe(this, Observer {
            it?.run {
                mainActivity_tv.text = ("$id $name $dni")
            }
            hideLoader()
        })

        mainViewModel.userInsertedLiveData.observe(this, Observer {
            if (it != 0L)
                Toast.makeText(this, "Insert successful", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Don't insert successful", Toast.LENGTH_SHORT).show()
        })
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

    override fun showUser(user: User) {
        user.run {
            mainActivity_tv.text = (id.toString() + name + dni)
        }
    }

    override fun showData(text: String) {
        mainActivity_tv.text = text
    }

}
