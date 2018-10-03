package performtest.com.news.ui.news

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.commons.utils.DiffCallback
import com.mikepenz.fastadapter.commons.utils.FastAdapterDiffUtil
import kotlinx.android.synthetic.main.fragment_news.view.*
import performtest.com.news.R
import performtest.com.news.repository.entity.News
import performtest.com.news.ui.base.BaseFragment
import performtest.com.news.ui.news.di.NewsViewModelFactory
import performtest.com.news.ui.web.WebActivity
import performtest.com.news.utils.observe


class NewsFragment : BaseFragment<NewsViewModel, NewsViewModelFactory>() {
  override val layout: Int
    get() = R.layout.fragment_news
  override val viewModelProvider: () -> ViewModel = {
    ViewModelProviders.of(this.activity!!, factory).get(
        NewsViewModel::class.java)
  }
  private lateinit var fastAdapter: FastAdapter<IItem<*, *>>
  private lateinit var itemAdapter: ItemAdapter<NewsItem>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(this.activity!!, factory).get(
        NewsViewModel::class.java)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    observeNews()
    initList(view)
    viewModel.getNews()
  }

  private fun initList(view: View) {
    view.newsList.layoutManager = LinearLayoutManager(context)
    itemAdapter = ItemAdapter()
    fastAdapter = FastAdapter.with(itemAdapter)
    view.newsList.adapter = fastAdapter

    fastAdapter.withOnClickListener { _, _, item, _ ->
      val intent = Intent(context, WebActivity::class.java)
      intent.putExtra(WebActivity.URL, (item as NewsItem).news.link)
      startActivity(intent)

      true
    }
  }


  private fun observeNews() {
    observe(viewModel.news) { list ->
      list?.let {
        setNewsToAdapter(it)
      }
    }
  }

  private fun setNewsToAdapter(news: MutableList<News>) {
    FastAdapterDiffUtil.set(itemAdapter, news.map { item -> NewsItem(item) },
        object : DiffCallback<NewsItem> {
          override fun areItemsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem.news.guid == newItem.news.guid
          }

          override fun getChangePayload(oldItem: NewsItem, oldItemPosition: Int, newItem: NewsItem,
              newItemPosition: Int): Any? {
            return null
          }

          override fun areContentsTheSame(oldItem: NewsItem, newItem: NewsItem): Boolean {
            return oldItem.news.category == newItem.news.category &&
                oldItem.news.description == newItem.news.description &&
                oldItem.news.pubDate == newItem.news.pubDate &&
                oldItem.news.title == newItem.news.title
          }

        })
  }

}