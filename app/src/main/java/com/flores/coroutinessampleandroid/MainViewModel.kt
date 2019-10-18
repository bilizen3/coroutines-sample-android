package com.flores.coroutinessampleandroid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * BaseView
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 10/13/2019
 */
class MainViewModel(
    private val userRepository: UserRepository
) : ViewModel(), CoroutineScope {

    private val job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    val userLiveData: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    val userInsertedLiveData: MutableLiveData<Long> by lazy {
        MutableLiveData<Long>()
    }

    fun insertData(name: String, dni: String) {
        launch(Dispatchers.IO) {
            userInsertedLiveData.postValue(userRepository.insertUser(name, dni))
        }
    }

    fun getUser(id: Int) {
        launch(Dispatchers.IO) {
            if (userRepository.getExistsUser(id) != 0)
                userLiveData.postValue(userRepository.getUser(id))
            else
                userLiveData.postValue(null)
        }
    }

    fun deleteJob() {
        job.cancel()
    }

}