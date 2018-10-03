package performtest.com.news.ui.news


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withClassName
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import performtest.com.news.R
import performtest.com.news.ui.main.MainActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class NewsFragmentTest {

  @Rule
  @JvmField
  var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

  @Test
  fun dropdownMenuShouldHasThreeElements() {
    val linearLayout = onView(
        allOf(withId(R.id.filter_container),
            childAtPosition(
                allOf(withId(R.id.dropdownView),
                    childAtPosition(
                        withClassName(`is`("android.support.constraint.ConstraintLayout")),
                        1)),
                0),
            isDisplayed()))
    linearLayout.perform(click())

    val textView = onView(
        allOf(childAtPosition(
            allOf(withId(R.id.ll_dropdown_items_container),
                childAtPosition(
                    withId(R.id.sv_dropdown_container),
                    0)),
            0),
            isDisplayed()))
    textView.check(matches(withText(mActivityTestRule.activity.getString(R.string.activity_main_news))))

    val textView2 = onView(
        allOf(childAtPosition(
            allOf(withId(R.id.ll_dropdown_items_container),
                childAtPosition(
                    withId(R.id.sv_dropdown_container),
                    0)),
            2),
            isDisplayed()))
    textView2.check(matches(withText(mActivityTestRule.activity.getString(R.string.activity_main_scores))))

    val textView3 = onView(
        allOf(childAtPosition(
            allOf(withId(R.id.ll_dropdown_items_container),
                childAtPosition(
                    withId(R.id.sv_dropdown_container),
                    0)),
            4),
            isDisplayed()))
    textView3.check(matches(withText(mActivityTestRule.activity.getString(R.string.activity_main_standings))))
  }

  private fun childAtPosition(
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
