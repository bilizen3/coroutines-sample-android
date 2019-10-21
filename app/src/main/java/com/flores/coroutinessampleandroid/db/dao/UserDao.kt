package com.flores.coroutinessampleandroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.flores.coroutinessampleandroid.db.entity.UserEntity

/**
 * UserDao
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 16/10/2019
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity): Long

    @Query("SELECT * FROM UserEntity WHERE UserEntity.id=:id")
    suspend fun getUser(id: Int): UserEntity

    @Query("SELECT COUNT(*) FROM UserEntity WHERE UserEntity.id=:id")
    suspend fun getExistsUser(id: Int): Int

}
