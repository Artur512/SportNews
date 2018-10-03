package performtest.com.news.ui.base

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.contentView
import performtest.com.news.utils.observe
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel, FACTORY : ViewModelProvider.Factory> : AppCompatActivity(), HasSupportFragmentInjector {
  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
  @Inject
  lateinit var factory: FACTORY
  abstract val layout: Int
  private val disposables = CompositeDisposable()
  lateinit var viewModel: VM
  abstract val viewModelProvider: () -> ViewModel
  private val mRegistry = LifecycleRegistry(this)
  override fun getLifecycle() = mRegistry
  override fun supportFragmentInjector(): AndroidInjector<Fragment> {
    return fragmentInjector
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)

    setContentView(layout)
    viewModel = viewModelProvider() as VM
    observeError()

  }

  override fun onDestroy() {
    super.onDestroy()
    disposables.dispose()
    viewModel.disposables.dispose()

  }

  private fun observeError() {
    observe(viewModel.error) { message ->
      message?.let {
        showSnackBar(it)
      }
    }
  }

  private fun showSnackBar(message: String) {
    val view = contentView
    view?.let {
      Snackbar.make(it, message,
          Snackbar.LENGTH_SHORT).show()
    }
  }

}