package performtest.com.news.ui.web

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_web.*
import performtest.com.news.R
import performtest.com.news.ui.base.BaseActivity
import performtest.com.news.ui.web.di.WebViewModelFactory

class WebActivity : BaseActivity<WebViewModel, WebViewModelFactory>() {
  override val layout: Int
    get() = R.layout.activity_web
  override val viewModelProvider: () -> ViewModel = {
    ViewModelProviders.of(this, factory).get(
        WebViewModel::class.java)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setUpToolbar()
    loadUrl(intent?.getStringExtra(URL))

  }

  private fun setUpToolbar() {
    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }

  private fun loadUrl(url: String?) {
    url?.let {
      webView.loadUrl(it)
    }
  }

  companion object {
    const val URL = "url"
  }
}
