package com.john.shadi.domain.usecase

import com.john.shadi.data.mapper.CloudErrorMapper
import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.repository.AppRepository
import com.john.shadi.domain.usecase.base.UseCase
import javax.inject.Inject

class UpdateUserUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository
) : UseCase<Long>(errorUtil) {
    var user :UserData?=null

    override suspend fun executeOnBackground(): Long {
        return user?.let { appRepository.updateuser(it) }!!
    }
}