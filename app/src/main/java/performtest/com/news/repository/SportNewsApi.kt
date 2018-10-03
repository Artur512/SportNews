package performtest.com.news.repository

import io.reactivex.Single
import performtest.com.news.repository.entity.RssNews
import performtest.com.news.repository.entity.ScoresResponse

import performtest.com.news.repository.entity.StandingResponse
import retrofit2.http.GET

interface SportNewsApi {
  @GET("latestnews.xml")
  fun getNewsList(): Single<RssNews>

  @GET("scores.xml")
  fun getScores(): Single<ScoresResponse>

  @GET("standings.xml")
  fun getStandings(): Single<StandingResponse>
}