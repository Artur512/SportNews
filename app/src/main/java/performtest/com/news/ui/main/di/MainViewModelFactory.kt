package performtest.com.news.ui.main.di


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import performtest.com.news.ui.main.MainViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(
    val viewModel: MainViewModel) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}
