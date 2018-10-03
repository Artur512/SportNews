package performtest.com.news.ui.standings.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import performtest.com.news.ui.standings.StandingsViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class StandingsViewModelFactory @Inject constructor(
    val viewModel: StandingsViewModel) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(StandingsViewModel::class.java)) {
      return viewModel as T
    }
    throw IllegalArgumentException("Unknown class name")
  }
}
