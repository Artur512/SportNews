package performtest.com.news.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import performtest.com.news.SportNewsApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      AndroidSupportInjectionModule::class,
      ActivitiesBindingModule::class,
      NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<SportNewsApplication> {
  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<SportNewsApplication>()
}