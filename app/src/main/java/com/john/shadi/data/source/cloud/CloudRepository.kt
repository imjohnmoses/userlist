package com.john.shadi.data.source.cloud

import com.john.shadi.data.restful.ApiService
import com.john.shadi.domain.model.UserDataModel

class CloudRepository(private val apIs: ApiService) : BaseCloudRepository {
    override suspend fun getHome(): UserDataModel {
        return apIs.getUserList().await()
    }
}
