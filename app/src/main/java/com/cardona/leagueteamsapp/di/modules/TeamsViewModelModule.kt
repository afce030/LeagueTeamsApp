package com.cardona.leagueteamsapp.di.modules

import androidx.lifecycle.ViewModel
import com.cardona.leagueteamsapp.di.viewModelFactory.ViewModelKey
import com.cardona.leagueteamsapp.presentation.viewmodels.TeamsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class TeamsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TeamsViewModel::class)
    abstract fun bindsViewModel(teamViewModel: TeamsViewModel): ViewModel

}