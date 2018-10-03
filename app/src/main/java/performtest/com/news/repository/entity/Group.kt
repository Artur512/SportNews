package performtest.com.news.repository.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "group", strict = false)
data class Group constructor(
    @field:ElementList(entry = "match", inline = true)
    @param:ElementList(entry = "match", inline = true)
    var matches: List<Match>? = null
)