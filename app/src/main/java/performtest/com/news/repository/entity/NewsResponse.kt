package performtest.com.news.repository.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
class NewsResponse constructor(
    @field:ElementList(entry = "item", inline = true)
    @param:ElementList(entry = "item", inline = true)
    var newsData: List<News>? = null
)