package performtest.com.news


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import performtest.com.news.di.DaggerAppComponent

open class SportNewsApplication : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent
        .builder()
        .create(this)
  }
}
