package performtest.com.news.ui.news.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import performtest.com.news.domain.news.NewsUseCase
import performtest.com.news.ui.news.NewsViewModel
import javax.inject.Inject


@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory @Inject constructor(
    val useCase: NewsUseCase) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
      return NewsViewModel(useCase) as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}
