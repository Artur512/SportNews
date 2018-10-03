package performtest.com.news.ui.standings

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import performtest.com.news.domain.standings.StandingsUseCase
import performtest.com.news.repository.entity.*

@RunWith(MockitoJUnitRunner::class)
class StandingsViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    private lateinit var useCase: StandingsUseCase
    @InjectMocks
    private lateinit var viewModel: StandingsViewModel

    private var response = arrayListOf(Ranking(), Ranking())

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        given(useCase.getStandings()).willReturn(Single.just(response))
    }

    @Test
    fun when_getting_standings_append_date_to_live_data_variable() {
        viewModel.getStandings()
        assertEquals(response, viewModel.standings.value)
    }
}