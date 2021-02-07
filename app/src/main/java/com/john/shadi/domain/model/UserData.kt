package com.john.shadi.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "userdata")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    var tid:Int,
    var stat:Int=0,
    @Embedded(prefix="dob") @SerializedName("dob")  val dob: Dob,
    @SerializedName("email")val email: String,
    @SerializedName("gender")val gender: String,
    @Embedded(prefix="location")  @SerializedName("location")val location: Location,
    @SerializedName("name")@Embedded(prefix="name") val name: Name,
    @SerializedName("phone")val phone: String,
    @Embedded(prefix="pic") @SerializedName("picture") val picture: Picture
)