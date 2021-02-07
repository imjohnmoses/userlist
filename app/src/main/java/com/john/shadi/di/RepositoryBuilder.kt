package com.john.shadi.di

import com.john.shadi.data.repository.AppRepoImplementation
import com.john.shadi.domain.repository.AppRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryBuilder {
    @Binds
    abstract fun bindRepository(rep:AppRepoImplementation):AppRepository
}