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
                view.showData("primer corrutine")
                "firts coroutintes"
            }

            val retorno2 = async(coroutineContext) {
                Thread.sleep(5000)
                view.showData("segundo corrutine")
                "second coroutintes"
            }

            view.showData(retorno + retorno2.await())

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