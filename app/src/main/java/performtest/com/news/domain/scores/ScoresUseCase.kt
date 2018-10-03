package performtest.com.news.domain.scores

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import performtest.com.news.domain.base.BaseUseCase
import performtest.com.news.repository.entity.ScoresResponse

interface ScoresUseCase : BaseUseCase {
  fun observeScores(observeScheduler: Scheduler = AndroidSchedulers.mainThread(),
      subscribeScheduler: Scheduler = Schedulers.computation()): Flowable<ScoresResponse>
}