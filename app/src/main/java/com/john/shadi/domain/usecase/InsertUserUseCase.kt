package com.john.shadi.domain.usecase

import com.john.shadi.data.mapper.CloudErrorMapper
import com.john.shadi.domain.model.UserDataModel
import com.john.shadi.domain.repository.AppRepository
import com.john.shadi.domain.usecase.base.UseCase
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    errorUtil: CloudErrorMapper,
    private val appRepository: AppRepository
) : UseCase<Long>(errorUtil) {
    var userList=UserDataModel(arrayListOf())
    override suspend fun executeOnBackground(): Long {
        return appRepository.saveuserList(userList)
    }
}