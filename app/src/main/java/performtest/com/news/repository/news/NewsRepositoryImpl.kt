package performtest.com.news.repository.news

import io.reactivex.Single
import performtest.com.news.repository.SportNewsApi
import performtest.com.news.repository.entity.News
import javax.inject.Inject


class NewsRepositoryImpl @Inject constructor(private val api: SportNewsApi) : NewsRepository {
  override fun getNews(): Single<List<News>> {
    return api.getNewsList()
        .map {
          it.response?.newsData ?: arrayListOf()
        }
  }

}