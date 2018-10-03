package performtest.com.news.ui.web.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class WebActivityModule {
  @Binds
  abstract fun provideViewModelFactory(
      factory: WebViewModelFactory): ViewModelProvider.Factory
}