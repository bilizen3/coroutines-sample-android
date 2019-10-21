package com.flores.coroutinessampleandroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.flores.coroutinessampleandroid.db.dao.UserDao
import com.flores.coroutinessampleandroid.db.entity.UserEntity

/**
 * AppDataBase
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 16/10/2019
 */
@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private var appDataBase: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase? {
            if (appDataBase == null) {
                appDataBase = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "databaseprueba"
                ).build()
            }
            return appDataBase
        }

    }

}