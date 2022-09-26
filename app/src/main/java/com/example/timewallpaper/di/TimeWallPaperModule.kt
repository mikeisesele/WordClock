package com.example.timewallpaper.di

import com.example.timewallpaper.domain.usecase.time.GetTimeUseCase
import com.example.timewallpaper.domain.usecase.time.IGetTimeUseCase
import com.example.timewallpaper.presentation.TimeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TimeWallPaperModule {

    @Provides
    fun provideTimeUseCase(): IGetTimeUseCase = GetTimeUseCase()

    @Provides
    fun provideTimeViewModel(getTimeUseCase: IGetTimeUseCase) = TimeViewModel(getTimeUseCase)
}
