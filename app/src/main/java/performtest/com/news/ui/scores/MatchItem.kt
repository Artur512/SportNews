package performtest.com.news.ui.scores

import android.annotation.SuppressLint
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.match_item_view.view.*
import performtest.com.news.R
import performtest.com.news.repository.entity.Match


class MatchItem(val match: Match) : AbstractItem<MatchItem, MatchItem.ViewHolder>() {
  @SuppressLint("ResourceType")
  override fun getType(): Int = R.layout.match_item_view

  override fun getLayoutRes(): Int = R.layout.match_item_view
  override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)


  class ViewHolder(val view: View) : FastAdapter.ViewHolder<MatchItem>(view) {


    override fun bindView(item: MatchItem, payloads: List<Any>) {
      view.teamA.text = item.match.teamA
      view.teamB.text = item.match.teamB

      view.teamGoalsA.text = item.match.fsA.toString()
      view.teamGoalsB.text = item.match.fsB.toString()
    }

    override fun unbindView(item: MatchItem) {
      view.teamA.text = null
      view.teamB.text = null

      view.teamGoalsA.text = null
      view.teamGoalsB.text = null
    }
  }
}