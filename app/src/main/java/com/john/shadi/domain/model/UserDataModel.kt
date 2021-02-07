package com.john.shadi.domain.model

import com.google.gson.annotations.SerializedName

data class  UserDataModel(
    //val info: Info,
    @SerializedName("results") val results: List<UserData>
)