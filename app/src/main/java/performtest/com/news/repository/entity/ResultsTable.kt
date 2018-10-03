package performtest.com.news.repository.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "resultstable", strict = false)
data class ResultsTable constructor(
    @field:ElementList(entry = "ranking", inline = true)
    @param:ElementList(entry = "ranking", inline = true)
    var rankings: List<Ranking>? = null
)