package performtest.com.news.ui.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import performtest.com.news.R

class StandingHeader @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
    defStyle: Int = 0, defStyleRes: Int = 0) : ConstraintLayout(context, attrs) {
  init {
    init(attrs, defStyle, defStyleRes)
  }

  private fun init(attrs: AttributeSet?, defStyle: Int, defStyleRes: Int) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    inflater.inflate(R.layout.standing_header, this, true)

  }

}