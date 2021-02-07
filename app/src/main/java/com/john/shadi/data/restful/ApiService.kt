package com.john.shadi.data.restful

import com.john.shadi.domain.model.UserDataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("api/?results=10")
    fun getUserList(
    ): Deferred<UserDataModel>


}