package com.john.shadi.domain.usecase

import com.john.shadi.data.mapper.CloudErrorMapper
import com.john.shadi.domain.model.UserDataModel
import com.john.shadi.domain.repository.AppRepository
import com.john.shadi.domain.usecase.base.UseCase
import javax.inject.Inject

class GetAllUserUseCase @Inject constructor(
        errorUtil: CloudErrorMapper,
        private val appRepository: AppRepository
) : UseCase<UserDataModel>(errorUtil) {
    override suspend fun executeOnBackground():UserDataModel {
        return appRepository.getAllUser()
    }
}