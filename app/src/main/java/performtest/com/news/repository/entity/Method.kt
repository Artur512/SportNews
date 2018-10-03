package performtest.com.news.repository.entity

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "method", strict = false)
data class Method(
    @field:ElementList(entry = "parameter", inline = true)
    @param:ElementList(entry = "parameter", inline = true)
    val parameters: List<Parameter>? = null)