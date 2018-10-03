package performtest.com.news.repository.news

import io.reactivex.Single
import performtest.com.news.repository.entity.News

interface NewsRepository {
  fun getNews(): Single<List<News>>
}