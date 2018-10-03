package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class RssNews(
    @field:Element(name = "channel")
    @param:Element(name = "channel")
    val response: NewsResponse? = null)

