package performtest.com.news.repository.entity

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "parameter", strict = false)
data class Parameter constructor(

    @field:Attribute(name = "name", required = false)
    @param:Attribute(name = "name", required = false)
    val name: String? = null,

    @field:Attribute(name = "value", required = false)
    @param:Attribute(name = "value", required = false)
    val value: String? = null
)