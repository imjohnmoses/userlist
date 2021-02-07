package com.john.shadi.di

import androidx.lifecycle.ViewModel
import com.john.shadi.vm.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    public abstract fun bindMainViewModel(viewModel:MainViewModel):ViewModel

}
