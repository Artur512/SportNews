package performtest.com.news.ui.main


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView.ViewHolder
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import performtest.com.news.R
import performtest.com.news.ui.EspressoRxJUnitRunner
// animations have to be disabled in developer options
class MainActivityTest : EspressoRxJUnitRunner() {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun clicksAllFeaturesInApp() {
        val linearLayout5 = onView(
                allOf(withId(R.id.filter_container),
                        childAtPosition(
                                allOf(withId(R.id.dropdownView),
                                        childAtPosition(
                                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()))
        linearLayout5.perform(click())

        val textView = onView(
                allOf(withText("Scores"),
                        childAtPosition(
                                allOf(withId(R.id.ll_dropdown_items_container),
                                        childAtPosition(
                                                withId(R.id.sv_dropdown_container),
                                                0)),
                                2)))
        textView.perform(scrollTo(), click())

        val linearLayout6 = onView(
                allOf(withId(R.id.filter_container),
                        childAtPosition(
                                allOf(withId(R.id.dropdownView),
                                        childAtPosition(
                                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()))
        linearLayout6.perform(click())

        val textView2 = onView(
                allOf(withText("Standings"),
                        childAtPosition(
                                allOf(withId(R.id.ll_dropdown_items_container),
                                        childAtPosition(
                                                withId(R.id.sv_dropdown_container),
                                                0)),
                                4)))
        textView2.perform(scrollTo(), click())

        val linearLayout7 = onView(
                allOf(withId(R.id.filter_container),
                        childAtPosition(
                                allOf(withId(R.id.dropdownView),
                                        childAtPosition(
                                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                                1)),
                                0),
                        isDisplayed()))
        linearLayout7.perform(click())

        val textView3 = onView(
                allOf(withText("News"),
                        childAtPosition(
                                allOf(withId(R.id.ll_dropdown_items_container),
                                        childAtPosition(
                                                withId(R.id.sv_dropdown_container),
                                                0)),
                                0)))
        textView3.perform(scrollTo(), click())

        val recyclerView = onView(
                allOf(withId(R.id.newsList),
                        childAtPosition(
                                withClassName(`is`("android.support.constraint.ConstraintLayout")),
                                0)))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
    }

}
