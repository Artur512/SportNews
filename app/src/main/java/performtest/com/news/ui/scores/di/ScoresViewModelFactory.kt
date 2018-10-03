package performtest.com.news.ui.scores.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import performtest.com.news.ui.scores.ScoresViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ScoresViewModelFactory @Inject constructor(
    val viewModel: ScoresViewModel) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(ScoresViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}
