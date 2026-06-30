package com.nmp.habittrackeranmp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "password")
    var password: String,
    @ColumnInfo(name = "is_login")
    var isLogin: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}