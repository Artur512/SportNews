package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "round", strict = false)
data class Round constructor(
    @field:ElementList(entry = "group", inline = true, required = false)
    @param:ElementList(entry = "group", inline = true, required = false)
    val groups: List<Group>? = null,

    @field:Element(name = "resultstable", required = false)
    @param:Element(name = "resultstable", required = false)
    val resultsTable: ResultsTable? = null

)