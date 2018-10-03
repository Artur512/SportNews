package performtest.com.news.domain.scores

import io.reactivex.Flowable
import io.reactivex.Scheduler
import performtest.com.news.domain.base.BaseUseCaseImpl
import performtest.com.news.repository.entity.ScoresResponse
import performtest.com.news.repository.scores.ScoresRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ScoresUseCaseImpl @Inject constructor(
    private val repository: ScoresRepository) : BaseUseCaseImpl(), ScoresUseCase {
  override fun observeScores(observeScheduler: Scheduler,
      subscribeScheduler: Scheduler): Flowable<ScoresResponse> {
    return Flowable.interval(0, 30, TimeUnit.SECONDS, subscribeScheduler)
        .flatMap {
          repository.getScores()
              .retry()
              .toFlowable()
        }.observeOn(observeScheduler)
  }
}
