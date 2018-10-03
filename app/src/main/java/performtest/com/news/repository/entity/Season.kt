package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "season", strict = false)
data class Season constructor(
    @field:Element(name = "round")
    @param:Element(name = "round")
    val round: Round? = null
)