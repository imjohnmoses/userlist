package com.john.shadi.domain.repository

import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.model.UserDataModel

interface AppRepository{
    suspend fun getAllUser(): UserDataModel
    suspend fun saveuserList(data: UserDataModel): Long
    suspend fun selectAllUser() : MutableList<UserData>
    suspend fun updateuser(userData: UserData) :Long
}