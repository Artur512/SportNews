package performtest.com.news.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import performtest.com.news.R

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
  liveData.observe(this, Observer(body))
}

fun <F : Fragment> AppCompatActivity.showFragment(tag: String, body: () -> F) {
  if (!isFragmentVisible(tag))
    supportFragmentManager.popBackStack()

  if (supportFragmentManager.findFragmentByTag(tag) == null) {
    supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, body.invoke(),
        tag).addToBackStack(tag).commit()
  } else {
    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,
        supportFragmentManager.findFragmentByTag(tag)).addToBackStack(tag).commit()
  }
}

fun AppCompatActivity.isFragmentVisible(tag: String): Boolean {
  return supportFragmentManager?.findFragmentByTag(tag)?.isVisible ?: false

}
