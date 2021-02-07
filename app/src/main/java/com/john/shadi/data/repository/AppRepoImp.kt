package com.john.shadi.data.repository

import com.john.shadi.data.source.cloud.BaseCloudRepository
import com.john.shadi.data.source.db.UserDataDao
import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.model.UserDataModel
import com.john.shadi.domain.repository.AppRepository
import javax.inject.Inject

class AppRepoImplementation @Inject constructor(
    private val cloudRepository: BaseCloudRepository,
    private val userDao: UserDataDao
) : AppRepository {


    override suspend fun getAllUser(): UserDataModel {
        return cloudRepository.getHome()
    }

    override suspend fun saveuserList(userList: UserDataModel): Long {
        if (userList.results.size > 0) {
            for (user in userList.results) {
                userDao.insertUser(user)
            }

        }
        return 0L
    }

    override suspend fun selectAllUser(): MutableList<UserData> {
        return userDao.selectAllUser()
    }

    override suspend fun updateuser(userData: UserData): Long {
        return 0
    }


}