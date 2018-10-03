package performtest.com.news.ui.standings

import android.annotation.SuppressLint
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.ranking_item_view.view.*
import performtest.com.news.R
import performtest.com.news.repository.entity.Ranking

class StandingItem(val ranking: Ranking) : AbstractItem<StandingItem, StandingItem.ViewHolder>() {
  @SuppressLint("ResourceType")
  override fun getType(): Int = R.layout.ranking_item_view

  override fun getLayoutRes(): Int = R.layout.ranking_item_view
  override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)


  class ViewHolder(val view: View) : FastAdapter.ViewHolder<StandingItem>(view) {


    override fun bindView(item: StandingItem, payloads: List<Any>) {
      view.rank.text = item.ranking.rank.toString()
      view.team.text = item.ranking.clubName
      view.p.text = item.ranking.points.toString()
      view.w.text = item.ranking.matchesWon.toString()
      view.d.text = item.ranking.matchesDraw.toString()
      view.l.text = item.ranking.matchesLost.toString()
      view.pts.text = item.ranking.points.toString()
      val gd = item.ranking.goalsPro - item.ranking.goalsAgainst
      view.gd.text = gd.toString()
    }

    override fun unbindView(item: StandingItem) {
      view.rank.text = null
      view.team.text = null
      view.p.text = null
      view.w.text = null
      view.d.text = null
      view.l.text = null
      view.pts.text = null
      view.gd.text = null
    }
  }
}