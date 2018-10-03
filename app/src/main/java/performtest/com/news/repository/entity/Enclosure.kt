package performtest.com.news.repository.entity

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "enclosure", strict = false)
data class Enclosure constructor(
    @field:Attribute(name = "url", required = false)
    @param:Attribute(name = "url", required = false)
    val url: String? = null
)