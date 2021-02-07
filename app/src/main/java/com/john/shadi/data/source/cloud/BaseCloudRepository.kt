package com.john.shadi.data.source.cloud

import com.john.shadi.domain.model.UserDataModel

interface BaseCloudRepository {
   suspend fun getHome(): UserDataModel
}