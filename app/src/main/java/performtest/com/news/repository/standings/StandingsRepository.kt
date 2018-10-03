package performtest.com.news.repository.standings

import io.reactivex.Single
import performtest.com.news.repository.entity.Ranking

interface StandingsRepository {
  fun getStandings(): Single<List<Ranking>>
}