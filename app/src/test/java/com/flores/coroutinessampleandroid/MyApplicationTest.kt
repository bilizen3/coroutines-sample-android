package com.flores.coroutinessampleandroid

import android.app.Application
import android.os.Build
import com.flores.coroutinessampleandroid.koin.appModule
import com.flores.coroutinessampleandroid.main.MainViewModel
import com.flores.coroutinessampleandroid.repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.BDDMockito.given
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * MyApplicationTest
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 05/11/2019
 */
@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class MyApplicationTest : KoinTest {

    val userRepository by inject<UserRepository>()
    val mainViewModel by inject<MainViewModel>()

    @Before
    fun before() {
        startKoin {
            printLogger(Level.DEBUG)
            androidContext(RuntimeEnvironment.systemContext)
            modules(appModule)
        }.checkModules()
    }

    @Test
    fun testUserRepository() {
        runBlocking {
            given(userRepository.getExistsUser(1)).willCallRealMethod()
//                Mockito.`when`(userRepository.getExistsUser(1))
//                Mockito.`when`(userRepository.insertUser("test", "123"))
//                Mockito.`when`(userRepository.getUser(1))
        }

    }

    @Test
    fun testMainViewModelRepository() {
        declareMock<MainViewModel> {
            // do your given behavior here
            given(this.getUser(1)).willCallRealMethod()
            given(this.insertData("alex", "123879")).willCallRealMethod()
        }
    }

    @Test
    fun tesKoinComponents() {
        declareMock<MainViewModel> {
            // do your given behavior here
            given(this.getUser(1)).willCallRealMethod()
            given(this.insertData("alex", "123879")).willCallRealMethod()
        }

    }

    @Test
    fun `checking modules`() {
        // use koinApplication instead of startKoin, to avoid having to close Koin after each test
        koinApplication { modules(appModule) }.checkModules()
    }


}