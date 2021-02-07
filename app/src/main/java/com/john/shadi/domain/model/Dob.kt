package com.john.shadi.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "dob",foreignKeys = [
    ForeignKey(
        entity = UserData::class,
        parentColumns = arrayOf("tid"),
        childColumns = arrayOf("parentId"),
        onDelete = ForeignKey.CASCADE
    )])
data class Dob(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val parentId:Int,
    val age: Int,
    val date: String
)