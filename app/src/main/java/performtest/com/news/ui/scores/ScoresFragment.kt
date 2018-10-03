package performtest.com.news.ui.scores

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
import kotlinx.android.synthetic.main.fragment_scores.view.dateHeader
import kotlinx.android.synthetic.main.fragment_scores.view.matchList
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import performtest.com.news.R
import performtest.com.news.repository.entity.Match
import performtest.com.news.ui.base.BaseFragment
import performtest.com.news.ui.scores.di.ScoresViewModelFactory
import performtest.com.news.utils.observe

class ScoresFragment : BaseFragment<ScoresViewModel, ScoresViewModelFactory>() {
  override val layout: Int
    get() = R.layout.fragment_scores
  override val viewModelProvider: () -> ViewModel = {
    ViewModelProviders.of(this.activity!!, factory).get(
        ScoresViewModel::class.java)
  }
  private lateinit var fastAdapter: FastAdapter<IItem<*, *>>
  private lateinit var itemAdapter: ItemAdapter<MatchItem>
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    initList(view)
    observeScores()
    observeDate(view)
    viewModel.getScores()
  }

  private fun initList(view: View) {
    view.matchList.layoutManager = LinearLayoutManager(context)
    itemAdapter = ItemAdapter()
    fastAdapter = FastAdapter.with(itemAdapter)
    view.matchList.adapter = fastAdapter
  }


  private fun observeScores() {
    observe(viewModel.scores) { list ->
      list?.let {
        uploadDataInAdapter(it)
      }
    }
  }

  private fun observeDate(view: View) {
    observe(viewModel.date) { value ->
      value.let {
        val date = LocalDate.parse(it,
            DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        view.dateHeader.text = date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))
      }
    }
  }

  private fun uploadDataInAdapter(matches: MutableList<Match>) {
    FastAdapterDiffUtil.set(itemAdapter, matches.map { item -> MatchItem(item) },
        object : DiffCallback<MatchItem> {
          override fun areItemsTheSame(oldItem: MatchItem, newItem: MatchItem): Boolean {
            return oldItem.match.matchId == newItem.match.matchId
          }

          override fun getChangePayload(oldItem: MatchItem, oldItemPosition: Int,
              newItem: MatchItem, newItemPosition: Int): Any? {
            return null
          }

          override fun areContentsTheSame(oldItem: MatchItem, newItem: MatchItem): Boolean {
            return oldItem.match.teamA == newItem.match.teamA &&
                oldItem.match.teamB == newItem.match.teamB &&
                oldItem.match.fsA == newItem.match.fsA &&
                oldItem.match.fsB == newItem.match.fsB
          }

        })
  }
}
