package performtest.com.news.repository.standings

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import performtest.com.news.repository.SportNewsApi
import performtest.com.news.repository.entity.*

@RunWith(MockitoJUnitRunner::class)
class StandingsRepositoryImplTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    private lateinit var api: SportNewsApi
    @InjectMocks
    private lateinit var repository: StandingsRepositoryImpl
    private var rankingsResponse = arrayListOf(Ranking(), Ranking())
    private var response = StandingResponse(competition = Competition(season = Season(round = Round(resultsTable = ResultsTable(rankings = rankingsResponse)))))
    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        given(api.getStandings()).willReturn(Single.just(response))
    }

    @Test
    fun when_get_standings_response_then_return_list_of_rankings() {
        repository.getStandings()
                .test()
                .assertValue(rankingsResponse)
    }
}