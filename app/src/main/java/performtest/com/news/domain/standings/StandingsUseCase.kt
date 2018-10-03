package performtest.com.news.domain.standings

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import performtest.com.news.domain.base.BaseUseCase
import performtest.com.news.repository.entity.Ranking

interface StandingsUseCase : BaseUseCase {
  fun getStandings(observeScheduler: Scheduler = AndroidSchedulers.mainThread(),
      subscribeScheduler: Scheduler = Schedulers.io()): Single<List<Ranking>>


}