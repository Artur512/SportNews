package performtest.com.news.repository.entity

import org.simpleframework.xml.Element
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "item", strict = false)
data class News constructor(
    @field:Element(name = "guid")
    @param:Element(name = "guid")
    val guid: String? = null,

    @field:Path("title")
    @field:Text(required = false)
    @param:Path("title")
    @param:Text(required = false)
    val title: String? = null,

    @field:Path("pubDate")
    @field:Text(required = false)
    @param:Path("pubDate")
    @param:Text(required = false)
    val pubDate: String? = null,

    @field:Path("category")
    @field:Text(required = false)
    @param:Path("category")
    @param:Text(required = false)
    val category: String? = null,

    @field:Path("link")
    @field:Text(required = false)
    @param:Path("link")
    @param:Text(required = false)
    val link: String? = null,

    @field:Path("description")
    @param:Text(required = false)
    @param:Path("description")
    @field:Text(required = false)
    val description: String? = null,

    @field:Element(name = "enclosure")
    @param:Element(name = "enclosure")
    var enclosure: Enclosure? = null


)

