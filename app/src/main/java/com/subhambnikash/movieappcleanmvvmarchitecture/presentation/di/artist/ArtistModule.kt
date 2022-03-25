package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.artist

import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.GetArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.UpdateArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist.ArtistActivityViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCases: GetArtistUseCases,
        updateArtistUseCases: UpdateArtistUseCases
    ): ArtistActivityViewModelFactory {
        return ArtistActivityViewModelFactory(getArtistUseCases,updateArtistUseCases)
    }
}