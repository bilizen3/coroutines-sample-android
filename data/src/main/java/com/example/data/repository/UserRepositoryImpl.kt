package com.example.data.repository

import androidx.room.withTransaction
import com.example.data.db.AppDataBase
import com.example.data.db.entity.UserEntity
import com.example.domain.model.User
import com.example.domain.repository.UserRepository

/**
 * UserRepositoryImpl
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 16/10/2019
 */
class UserRepositoryImpl(private val appDataBase: AppDataBase) : UserRepository {

    override suspend fun getExistsUser(id: Int): Int {
        return appDataBase.withTransaction {
            appDataBase.userDao().getExistsUser(id)
        }
    }

    override suspend fun insertUser(name: String, dni: String): Long {
        return appDataBase.withTransaction {
            appDataBase.userDao().insertUser(
                UserEntity(0, name, dni)
            )
        }
    }

    override suspend fun getUser(id: Int): User {
        return appDataBase.withTransaction {
            appDataBase.userDao().getUser(id).let {
                User(
                    it.id,
                    it.name,
                    it.dni
                )
            }
        }
    }

}