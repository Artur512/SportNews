package performtest.com.news.ui.standings

import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import performtest.com.news.domain.standings.StandingsUseCase
import performtest.com.news.repository.entity.Ranking
import performtest.com.news.ui.base.BaseViewModel
import javax.inject.Inject

class StandingsViewModel @Inject constructor(
    private val useCase: StandingsUseCase) : BaseViewModel() {
  val standings = MutableLiveData<List<Ranking>>()
  fun getStandings() {
    useCase.getStandings()
        .subscribeBy({
          onError(it)
        }, {
          standings.value = it
        }).addTo(disposables)
  }
}