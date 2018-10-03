package performtest.com.news.domain.news

import io.reactivex.Scheduler
import io.reactivex.Single
import performtest.com.news.di.scopes.PerFragment
import performtest.com.news.domain.base.BaseUseCaseImpl
import performtest.com.news.repository.entity.News
import performtest.com.news.repository.news.NewsRepository
import javax.inject.Inject

@PerFragment
class NewsUseCaseImpl @Inject constructor(
    private val repository: NewsRepository) : BaseUseCaseImpl(), NewsUseCase {
  override fun getNews(observeScheduler: Scheduler,
      subscribeScheduler: Scheduler): Single<List<News>> {
    return repository.getNews()
        .subscribeOn(subscribeScheduler)
        .observeOn(observeScheduler)
  }
}