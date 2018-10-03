package performtest.com.news.ui.news

import android.annotation.SuppressLint
import android.view.View
import com.bumptech.glide.Glide
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.news_item_view.view.*
import org.threeten.bp.LocalDateTime
import performtest.com.news.R
import performtest.com.news.repository.entity.News
import org.threeten.bp.format.DateTimeFormatter
import java.util.Locale

class NewsItem(val news: News) : AbstractItem<NewsItem, NewsItem.ViewHolder>() {
  @SuppressLint("ResourceType")
  override fun getType(): Int = R.layout.news_item_view

  override fun getLayoutRes(): Int = R.layout.news_item_view
  override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)


  class ViewHolder(val view: View) : FastAdapter.ViewHolder<NewsItem>(view) {


    override fun bindView(item: NewsItem, payloads: List<Any>) {
      Glide.with(view.context)
          .load(item.news.enclosure?.url)
          .into(view.image)
      view.description.text = item.news.description
      val date = LocalDateTime.parse(item.news.pubDate,
          DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH))
      view.date.text = date.format(DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy, HH:MM"))
    }

    override fun unbindView(item: NewsItem) {
      view.image.setImageBitmap(null)
      view.date.text = null
      view.description.text = null
    }
  }
}