package performtest.com.news.ui.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, FACTORY : ViewModelProvider.Factory> : Fragment(), LifecycleRegistryOwner {
  @Inject
  lateinit var factory: FACTORY
  abstract val layout: Int

  private val disposables = CompositeDisposable()
  lateinit var viewModel: VM
  abstract val viewModelProvider: () -> ViewModel
  private val mRegistry = LifecycleRegistry(this)
  override fun getLifecycle() = mRegistry

  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)

  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = viewModelProvider() as VM
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    return inflater.inflate(layout, container, false)
  }

  override fun onDestroy() {
    super.onDestroy()
    disposables.clear()
    viewModel.disposables.clear()
  }
}