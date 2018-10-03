package performtest.com.news.repository.entity

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "match", strict = false)
data class Match constructor(
    @field:Attribute(name = "match_id", required = false)
    @param:Attribute(name = "match_id", required = false)
    val matchId: Long? = null,
    @field:Attribute(name = "team_A_name", required = false)
    @param:Attribute(name = "team_A_name", required = false)
    val teamA: String? = null,

    @field:Attribute(name = "team_B_name", required = false)
    @param:Attribute(name = "team_B_name", required = false)
    val teamB: String? = null,


    @field:Attribute(name = "fs_A", required = false)
    @param:Attribute(name = "fs_A", required = false)
    val fsA: Long? = null,

    @field:Attribute(name = "fs_B", required = false)
    @param:Attribute(name = "fs_B", required = false)
    val fsB: Long? = null
)