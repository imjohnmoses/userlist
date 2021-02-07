package com.john.shadi.di

import androidx.lifecycle.ViewModelProvider
import com.john.shadi.vm.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [ (RepositoryBuilder::class)])
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(vmFactory: ViewModelFactory) : ViewModelProvider.Factory
}
