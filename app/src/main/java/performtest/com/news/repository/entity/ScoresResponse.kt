package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "gsmrs", strict = false)
data class ScoresResponse(
    @field:Element(name = "competition")
    @param:Element(name = "competition")
    var competition: Competition? = null,
    @field:Element(name = "method")
    @param:Element(name = "method")
    var method: Method? = null)


