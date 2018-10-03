package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "gsmrs", strict = false)
data class StandingResponse(
    @field:Element(name = "competition")
    @param:Element(name = "competition")
    val competition: Competition? = null)
