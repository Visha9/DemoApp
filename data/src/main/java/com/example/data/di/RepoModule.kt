package com.example.data.di

import com.example.data.remote.GithubApi
import com.example.data.repository.GithubRepositoryImpl
import com.example.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {

    @Provides
    fun provideUserRepository(api: GithubApi): GithubRepository {
        return GithubRepositoryImpl(api)
    }
}