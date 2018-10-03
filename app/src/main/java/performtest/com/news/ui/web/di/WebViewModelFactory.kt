package performtest.com.news.ui.web.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import performtest.com.news.ui.web.WebViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class WebViewModelFactory @Inject constructor(
    val viewModel: WebViewModel) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(WebViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}
