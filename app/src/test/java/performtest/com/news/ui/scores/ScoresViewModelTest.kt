package performtest.com.news.ui.scores

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Flowable
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
import performtest.com.news.domain.scores.ScoresUseCase
import performtest.com.news.repository.entity.*

@RunWith(MockitoJUnitRunner::class)
class ScoresViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    private lateinit var useCase: ScoresUseCase
    @InjectMocks
    private lateinit var viewModel: ScoresViewModel

    private var response = ScoresResponse().apply {
        method = Method(arrayListOf(Parameter(name = "date", value = "exampleDate")))
        competition = Competition( season = Season(round = Round()))
    }

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        given(useCase.observeScores()).willReturn(Flowable.just(response))
    }

    @Test
    fun when_get_scores_append_date_to_live_data_variable() {
        viewModel.getScores()
        assertEquals(response.method?.parameters?.first { it.name == "date" }?.value, viewModel.date.value)
    }
}