package performtest.com.news.ui.standings.di

import dagger.Binds
import dagger.Module
import performtest.com.news.di.scopes.PerFragment
import performtest.com.news.domain.standings.StandingsUseCase
import performtest.com.news.domain.standings.StandingsUseCaseImpl
import performtest.com.news.repository.standings.StandingsRepository
import performtest.com.news.repository.standings.StandingsRepositoryImpl

@Module
abstract class StandingsFragmentModule {
  @PerFragment
  @Binds
  abstract fun provideNewsUseCase(useCase: StandingsUseCaseImpl): StandingsUseCase

  @PerFragment
  @Binds
  abstract fun provideScoresRepository(repository: StandingsRepositoryImpl): StandingsRepository
}