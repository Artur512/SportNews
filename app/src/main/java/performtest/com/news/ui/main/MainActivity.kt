package performtest.com.news.ui.main


import  android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.asksira.dropdownview.OnDropDownSelectionListener
import kotlinx.android.synthetic.main.activity_main.*

import performtest.com.news.R
import performtest.com.news.ui.base.BaseActivity
import performtest.com.news.ui.main.di.MainViewModelFactory
import performtest.com.news.ui.news.NewsFragment
import performtest.com.news.ui.scores.ScoresFragment
import performtest.com.news.ui.standings.StandingsFragment
import performtest.com.news.utils.showFragment

class MainActivity : BaseActivity<MainViewModel, MainViewModelFactory>() {
  override val viewModelProvider: () -> ViewModel = {
    ViewModelProviders.of(this, factory).get(
        MainViewModel::class.java)
  }
  override val layout: Int = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setUpDropDownMenu()
  }

  private fun setUpDropDownMenu() {
    dropdownView.setDropDownListItem(arrayListOf(getString(R.string.activity_main_news),
        getString(R.string.activity_main_scores), getString(R.string.activity_main_standings)))
    dropdownView.onSelectionListener = OnDropDownSelectionListener { view, position ->
      when (position) {
        0 -> showFragment("news", { NewsFragment() })
        1 -> showFragment("scores", { ScoresFragment() })
        2 -> showFragment("standings", { StandingsFragment() })
      }
    }

    if (dropdownView.selectingPosition < 0) {
      dropdownView.selectingPosition = 0
    }
  }
}
