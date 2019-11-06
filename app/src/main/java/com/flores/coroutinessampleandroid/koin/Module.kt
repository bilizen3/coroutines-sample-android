package com.flores.coroutinessampleandroid.koin

import com.flores.coroutinessampleandroid.main.MainViewModel
import com.flores.coroutinessampleandroid.db.AppDataBase
import com.flores.coroutinessampleandroid.repository.UserRepository
import com.flores.coroutinessampleandroid.repository.UserRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Module
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 05/11/2019
 */

val appModule = module {

    factory {
        AppDataBase.getInstance(androidContext())
    }

    single<UserRepository> { UserRepositoryImpl(get()) }

    viewModel { MainViewModel(get()) }

}