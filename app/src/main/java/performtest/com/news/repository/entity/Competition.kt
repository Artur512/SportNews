package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "competition", strict = false)
data class Competition constructor(
    @field:Element(name = "season")
    @param:Element(name = "season")
    var season: Season? = null
)