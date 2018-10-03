package performtest.com.news.ui.scores.di

import dagger.Binds
import dagger.Module
import performtest.com.news.di.scopes.PerFragment
import performtest.com.news.domain.scores.ScoresUseCase
import performtest.com.news.domain.scores.ScoresUseCaseImpl
import performtest.com.news.repository.scores.ScoresRepository
import performtest.com.news.repository.scores.ScoresRepositoryImpl

@Module
abstract class ScoresFragmentModule {

  @PerFragment
  @Binds
  abstract fun provideNewsUseCase(useCase: ScoresUseCaseImpl): ScoresUseCase

  @PerFragment
  @Binds
  abstract fun provideScoresRepository(repository: ScoresRepositoryImpl): ScoresRepository
}