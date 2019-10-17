package com.example.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * UserEntity
 *
 * @author Bill Flores - bilizen3@gmail.com
 * @since 16/10/2019
 */
@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val dni: String?
)