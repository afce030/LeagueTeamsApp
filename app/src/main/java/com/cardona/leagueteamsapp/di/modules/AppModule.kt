package com.cardona.leagueteamsapp.di.modules

import android.content.Context
import androidx.room.Room
import com.cardona.data.persistence.ITeamsPersistenceDataSource
import com.cardona.data.remoteSources.ITeamsDataSource
import com.cardona.data.repositories.TeamsRepository
import com.cardona.domain.repositories.ITeamsRepository
import com.cardona.domain.useCases.GetLeagueTeams
import com.cardona.leagueteamsapp.frameworks.dataMappers.ITeamsMapper
import com.cardona.leagueteamsapp.frameworks.dataMappers.TeamsMapper
import com.cardona.leagueteamsapp.frameworks.retrofit.LeagueWS
import com.cardona.leagueteamsapp.frameworks.retrofit.TeamsDataSource
import com.cardona.leagueteamsapp.frameworks.retrofit.Utils
import com.cardona.leagueteamsapp.frameworks.room.TeamsPersistentDataSource
import com.cardona.leagueteamsapp.frameworks.room.databases.LeaguesDatabase
import com.cardona.leagueteamsapp.presentation.adapters.TeamsAdapter
import com.cardona.leagueteamsapp.presentation.viewCommands.wrappers.CommandInvoker
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context{
        return context
    }

    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Singleton
    @Provides
    fun provideGsonConverter(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val okhttpClientBuilder = OkHttpClient.Builder()
        okhttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)
        okhttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
        return okhttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun providesRetrofitService(okHttpClient: OkHttpClient, gson: GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(gson)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun providesWebService(retrofit: Retrofit): LeagueWS{
        return retrofit.create(LeagueWS::class.java)
    }

    @Singleton
    @Provides
    fun providesDataMapper(): ITeamsMapper{
        return TeamsMapper()
    }

    @Singleton
    @Provides
    fun providesDataSource(
        iTeamsMapper: ITeamsMapper,
        leagueWS: LeagueWS
    ): ITeamsDataSource{
        return TeamsDataSource(iTeamsMapper, leagueWS)
    }

    @Singleton
    @Provides
    fun providesDatabase(context: Context): LeaguesDatabase{
        return Room.databaseBuilder(
            context,
            LeaguesDatabase::class.java,
            "leaguesDB"
        ).build()
    }

    @Singleton
    @Provides
    fun providesLocalDataSource(
        iTeamsMapper: ITeamsMapper,
        leaguesDatabase: LeaguesDatabase
    ): ITeamsPersistenceDataSource{
        return TeamsPersistentDataSource(iTeamsMapper, leaguesDatabase)
    }

    @Singleton
    @Provides
    fun providesRepository(
        iTeamsDataSource: ITeamsDataSource,
        iTeamsPersistenceDataSource: ITeamsPersistenceDataSource
    ): ITeamsRepository{
        return TeamsRepository(iTeamsDataSource, iTeamsPersistenceDataSource)
    }

    @Singleton
    @Provides
    fun providesUseCase(teamsRepository: ITeamsRepository): GetLeagueTeams{
        return GetLeagueTeams(teamsRepository)
    }

    @Singleton
    @Provides
    fun providesCommandInvoker() =
        CommandInvoker()

    @Singleton
    @Provides
    fun providesAdapter(context: Context): TeamsAdapter{
        return TeamsAdapter(context)
    }
}