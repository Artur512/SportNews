package performtest.com.news.repository.standings

import io.reactivex.Single
import performtest.com.news.repository.SportNewsApi
import performtest.com.news.repository.entity.Ranking
import javax.inject.Inject

class StandingsRepositoryImpl @Inject constructor(
    private val api: SportNewsApi) : StandingsRepository {
  override fun getStandings(): Single<List<Ranking>> {
    return api.getStandings()
        .map {
          it.competition?.season?.round?.resultsTable?.rankings
        }
  }
}