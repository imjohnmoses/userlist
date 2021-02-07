package com.john.shadi.domain.usecase

import com.john.shadi.data.mapper.CloudErrorMapper
import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.repository.AppRepository
import com.john.shadi.domain.usecase.base.UseCase
import javax.inject.Inject

class GetAllUserFDbUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository
) : UseCase<MutableList<UserData>>(errorUtil) {
    override suspend fun executeOnBackground(): MutableList<UserData> {
        return appRepository.selectAllUser()
    }
}