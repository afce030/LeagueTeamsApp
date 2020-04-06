package com.cardona.leagueteamsapp.di

import com.cardona.leagueteamsapp.di.modules.AppModule
import com.cardona.leagueteamsapp.di.modules.TeamsViewModelModule
import com.cardona.leagueteamsapp.di.modules.ViewModelModule
import com.cardona.leagueteamsapp.presentation.fragments.TeamDescriptionFragment
import com.cardona.leagueteamsapp.presentation.fragments.TeamsListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    TeamsViewModelModule::class,
    ViewModelModule::class
])
interface AppComponent {

    fun inject(teamsListFragment: TeamsListFragment)
    fun inject(teamDescriptionFragment: TeamDescriptionFragment)

    /*@Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }*/
}