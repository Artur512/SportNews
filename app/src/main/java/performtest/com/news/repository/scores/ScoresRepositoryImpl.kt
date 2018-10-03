package performtest.com.news.repository.scores

import io.reactivex.Single
import performtest.com.news.repository.SportNewsApi
import performtest.com.news.repository.entity.ScoresResponse
import javax.inject.Inject

class ScoresRepositoryImpl @Inject constructor(private val api: SportNewsApi) : ScoresRepository {
  override fun getScores(): Single<ScoresResponse> {
    return api.getScores()

  }
}