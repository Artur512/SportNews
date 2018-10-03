package performtest.com.news.repository.scores

import io.reactivex.Single
import performtest.com.news.repository.entity.ScoresResponse

interface ScoresRepository {
  fun getScores(): Single<ScoresResponse>
}