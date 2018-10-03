package performtest.com.news.ui.scores

import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import performtest.com.news.domain.scores.ScoresUseCase
import performtest.com.news.repository.entity.Match
import performtest.com.news.ui.base.BaseViewModel
import javax.inject.Inject

class ScoresViewModel @Inject constructor(private val useCase: ScoresUseCase) : BaseViewModel() {
  val scores = MutableLiveData<MutableList<Match>>()
  val date = MutableLiveData<String>()
  fun getScores() {
    useCase.observeScores()
        .subscribeBy(onError = {
          onError(it)
        }, onNext = { response ->
          date.value = response.method?.parameters?.find { it.name == "date" }?.value
          val matches = mutableListOf<Match>()
          response.competition?.season?.round?.groups?.forEach { group ->
            group.matches?.map {
              matches.add(it)
            }
          }
          scores.value = matches
        }).addTo(disposables)

  }
}