package performtest.com.news.ui.main.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {
  @Binds
  abstract fun provideViewModelFactory(
      factory: MainViewModelFactory): ViewModelProvider.Factory


}