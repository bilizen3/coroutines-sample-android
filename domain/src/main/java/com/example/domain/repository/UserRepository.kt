package com.example.domain.repository

import com.example.domain.model.User

/**
 * UserRepository
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 16/10/2019
 */
interface UserRepository {

    suspend fun insertUser(name: String, dni: String): Long

    suspend fun getUser(id: Int): User

    suspend fun getExistsUser(id: Int): Int

}