package performtest.com.news.domain.standings

import io.reactivex.Scheduler
import io.reactivex.Single
import performtest.com.news.domain.base.BaseUseCaseImpl
import performtest.com.news.repository.entity.Ranking
import performtest.com.news.repository.standings.StandingsRepository
import javax.inject.Inject

class StandingsUseCaseImpl @Inject constructor(
    private val repository: StandingsRepository) : BaseUseCaseImpl(), StandingsUseCase {
  override fun getStandings(observeScheduler: Scheduler,
      subscribeScheduler: Scheduler): Single<List<Ranking>> {
    return repository.getStandings()
        .subscribeOn(subscribeScheduler)
        .observeOn(observeScheduler)
  }
}