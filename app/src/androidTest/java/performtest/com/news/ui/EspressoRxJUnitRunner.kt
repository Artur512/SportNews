package performtest.com.news.ui

import android.os.AsyncTask
import android.support.test.runner.AndroidJUnitRunner
import android.view.View
import android.view.ViewGroup
import io.reactivex.Scheduler
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


open class EspressoRxJUnitRunner : AndroidJUnitRunner() {

    override fun onStart() {
        val asyncTaskScheduler = Function<Scheduler, Scheduler> {
            Schedulers.from(AsyncTask.THREAD_POOL_EXECUTOR)
        }

        RxJavaPlugins.setIoSchedulerHandler(asyncTaskScheduler)
        RxJavaPlugins.setSingleSchedulerHandler(asyncTaskScheduler)


        super.onStart()
    }
    protected fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}