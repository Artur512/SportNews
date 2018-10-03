package performtest.com.news.ui.news.di

import dagger.Binds
import dagger.Module
import performtest.com.news.di.scopes.PerFragment
import performtest.com.news.domain.news.NewsUseCase
import performtest.com.news.domain.news.NewsUseCaseImpl
import performtest.com.news.repository.news.NewsRepository
import performtest.com.news.repository.news.NewsRepositoryImpl

@Module
abstract class NewsFragmentModule {

  @PerFragment
  @Binds
  abstract fun provideNewsUseCase(useCase: NewsUseCaseImpl): NewsUseCase

  @PerFragment
  @Binds
  abstract fun provideNewsRepository(repository: NewsRepositoryImpl): NewsRepository
}