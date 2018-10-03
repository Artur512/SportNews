package performtest.com.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import performtest.com.news.di.scopes.PerFragment
import performtest.com.news.ui.news.NewsFragment
import performtest.com.news.ui.news.di.NewsFragmentModule
import performtest.com.news.ui.scores.ScoresFragment
import performtest.com.news.ui.scores.di.ScoresFragmentModule
import performtest.com.news.ui.standings.StandingsFragment
import performtest.com.news.ui.standings.di.StandingsFragmentModule


@Module
abstract class FragmentBindingModule {
  @PerFragment
  @ContributesAndroidInjector(modules = [NewsFragmentModule::class])
  abstract fun newsFragment(): NewsFragment

  @PerFragment
  @ContributesAndroidInjector(modules = [ScoresFragmentModule::class])
  abstract fun scoresFragment(): ScoresFragment

  @PerFragment
  @ContributesAndroidInjector(modules = [StandingsFragmentModule::class])
  abstract fun standingsFragment(): StandingsFragment
}