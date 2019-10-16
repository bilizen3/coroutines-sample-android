package com.flores.coroutinessampleandroid

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel(val view: View) : CoroutineScope {
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    public fun execute() {
        job = GlobalScope.launch(Dispatchers.Default) {

            val retorno = withContext(coroutineContext) {

                Thread.sleep(6000)
                view.showData("primer corrutine")

            }

            val retorno2 = withContext(coroutineContext) {
                view.showData("segundo corrutine")
            }


        }
    }


    suspend fun suspendingFunction(text: String): String {
        // Long running task
        return "$text firts suspend"
    }

    suspend fun suspendingFunction2(text: String): String {
        // Long running task
        return "$text firts suspend2"
    }


    private fun showData(a: String) {
        view.showData(a)
    }

    public fun deleteJob() {
        job.cancel()
    }
}