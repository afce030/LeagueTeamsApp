package com.cardona.leagueteamsapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.cardona.leagueteamsapp.di.viewModelFactory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}