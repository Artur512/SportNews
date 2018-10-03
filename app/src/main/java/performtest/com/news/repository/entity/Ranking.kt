package performtest.com.news.repository.entity

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "ranking", strict = false)
data class Ranking @JvmOverloads constructor(
    @field:Attribute(name = "team_id", required = false)
    @param:Attribute(name = "team_id", required = false)
    val teamId: Long? = null,
    @field:Attribute(name = "rank", required = false)
    @param:Attribute(name = "rank", required = false)
    val rank: Long? = null,
    @field:Attribute(name = "last_rank", required = false)
    @param:Attribute(name = "last_rank", required = false)
    val lastRank: String? = null,
    @field:Attribute(name = "club_name", required = false)
    @param:Attribute(name = "club_name", required = false)
    val clubName: String? = null,
    @field:Attribute(name = "matches_total", required = false)
    @param:Attribute(name = "matches_total", required = false)
    val matchesTotal: Long? = null,
    @field:Attribute(name = "matches_won", required = false)
    @param:Attribute(name = "matches_won", required = false)
    val matchesWon: Long? = null,
    @field:Attribute(name = "matches_draw", required = false)
    @param:Attribute(name = "matches_draw", required = false)
    val matchesDraw: Long? = null,
    @field:Attribute(name = "matches_lost", required = false)
    @param:Attribute(name = "matches_lost", required = false)
    val matchesLost: Long? = null,
    @field:Attribute(name = "goals_against", required = false)
    @param:Attribute(name = "goals_against", required = false)
    val goalsAgainst: Long = 0,
    @field:Attribute(name = "points", required = false)
    @param:Attribute(name = "points", required = false)
    val points: Long? = null,

    @field:Attribute(name = "goals_pro", required = false)
    @param:Attribute(name = "goals_pro", required = false)
    val goalsPro: Long = 0
)