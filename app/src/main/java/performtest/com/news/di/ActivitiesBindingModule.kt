package performtest.com.news.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import performtest.com.news.di.scopes.PerActivity
import performtest.com.news.ui.main.MainActivity
import performtest.com.news.ui.main.di.MainActivityModule
import performtest.com.news.ui.web.WebActivity
import performtest.com.news.ui.web.di.WebActivityModule

@Module
abstract class ActivitiesBindingModule {
  @PerActivity
  @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBindingModule::class])
  abstract fun mainActivity(): MainActivity


  @PerActivity
  @ContributesAndroidInjector(modules = [WebActivityModule::class])
  abstract fun webActivity(): WebActivity

}