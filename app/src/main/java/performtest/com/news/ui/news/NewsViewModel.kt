package performtest.com.news.ui.news

import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import performtest.com.news.domain.news.NewsUseCase
import performtest.com.news.repository.entity.News
import performtest.com.news.ui.base.BaseViewModel
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val newsUseCase: NewsUseCase) : BaseViewModel() {
  val news = MutableLiveData<MutableList<News>>()

  fun getNews() {
    newsUseCase.getNews()
        .subscribeBy(onError = {
          onError(it)
        }, onSuccess = {
          news.value = it.toMutableList()
        }).addTo(disposables)
  }
}