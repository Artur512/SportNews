package performtest.com.news.ui.base


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel(

) {
  val disposables = CompositeDisposable()
  val error = MutableLiveData<String>()
  open fun onError(throwable: Throwable) {
    error.value = throwable.localizedMessage
    error.value = null
  }
}