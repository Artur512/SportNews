package performtest.com.news.ui.standings

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View

import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.commons.utils.DiffCallback
import com.mikepenz.fastadapter.commons.utils.FastAdapterDiffUtil
import kotlinx.android.synthetic.main.fragment_standings.view.*

import performtest.com.news.R
import performtest.com.news.repository.entity.Ranking
import performtest.com.news.ui.base.BaseFragment
import performtest.com.news.ui.standings.di.StandingsViewModelFactory
import performtest.com.news.utils.observe

class StandingsFragment : BaseFragment<StandingsViewModel, StandingsViewModelFactory>() {
  override val layout: Int
    get() = R.layout.fragment_standings
  override val viewModelProvider: () -> ViewModel = {
    ViewModelProviders.of(this, factory).get(
        StandingsViewModel::class.java)
  }
  private lateinit var fastAdapter: FastAdapter<IItem<*, *>>
  private lateinit var itemAdapter: ItemAdapter<StandingItem>

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initList(view)
    observeStandings()
    viewModel.getStandings()

  }

  private fun initList(view: View) {
    view.standings.layoutManager = LinearLayoutManager(context)
    itemAdapter = ItemAdapter()
    fastAdapter = FastAdapter.with(itemAdapter)
    view.standings.adapter = fastAdapter
  }

  private fun observeStandings() {
    observe(viewModel.standings) { items ->
      items?.let { list ->
        reloadDataInAdapter(list.sortedBy { it.rank })
      }
    }
  }

  private fun reloadDataInAdapter(list: List<Ranking>) {
    FastAdapterDiffUtil.set(itemAdapter, list.map { item -> StandingItem(item) },
        object : DiffCallback<StandingItem> {
          override fun areItemsTheSame(oldItem: StandingItem, newItem: StandingItem): Boolean {
            return oldItem.ranking.teamId == newItem.ranking.teamId
          }

          override fun getChangePayload(oldItem: StandingItem, oldItemPosition: Int,
              newItem: StandingItem, newItemPosition: Int): Any? {
            return null
          }

          override fun areContentsTheSame(oldItem: StandingItem, newItem: StandingItem): Boolean {
            return oldItem.ranking.clubName == newItem.ranking.clubName &&
                oldItem.ranking.goalsAgainst == newItem.ranking.goalsAgainst &&
                oldItem.ranking.lastRank == newItem.ranking.lastRank &&
                oldItem.ranking.matchesDraw == newItem.ranking.matchesDraw &&
                oldItem.ranking.matchesLost == newItem.ranking.matchesLost &&
                oldItem.ranking.matchesTotal == newItem.ranking.matchesTotal &&
                oldItem.ranking.matchesWon == newItem.ranking.matchesWon &&
                oldItem.ranking.points == newItem.ranking.points &&
                oldItem.ranking.rank == newItem.ranking.rank
          }

        })
  }
}