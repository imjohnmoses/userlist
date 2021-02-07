package com.john.shadi.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "pic",foreignKeys = [
    ForeignKey(
        entity = UserData::class,
        parentColumns = arrayOf("tid"),
        childColumns = arrayOf("parentId"),
        onDelete = ForeignKey.CASCADE
    )])
data class Picture(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val parentId:Int,
    val large: String,
    val medium: String,
    val thumbnail: String
)