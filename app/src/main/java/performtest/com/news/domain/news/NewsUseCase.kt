package performtest.com.news.domain.news

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import performtest.com.news.domain.base.BaseUseCase
import performtest.com.news.repository.entity.News

interface NewsUseCase : BaseUseCase {
  fun getNews(observeScheduler: Scheduler = AndroidSchedulers.mainThread(),
      subscribeScheduler: Scheduler = Schedulers.io()): Single<List<News>>
}