package performtest.com.news.domain.scores
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import io.reactivex.subscribers.TestSubscriber
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import performtest.com.news.repository.entity.ScoresResponse
import performtest.com.news.repository.scores.ScoresRepository
import java.util.concurrent.TimeUnit


@RunWith(MockitoJUnitRunner::class)
class ScoresUseCaseImplTest {
    @Mock
    private lateinit var repository: ScoresRepository
    @InjectMocks
    private lateinit var useCase: ScoresUseCaseImpl

    @Before
    fun setUp() {
        given(repository.getScores()).willReturn(Single.just(ScoresResponse()))
    }

    @Test
    fun when_observe_scores_should_call_use_case_every_30s() {
        val scheduler = TestScheduler()
        val testSubscriber = TestSubscriber<ScoresResponse>()
        useCase.observeScores(scheduler, scheduler)
                .subscribe(testSubscriber)
        scheduler.advanceTimeBy(30, TimeUnit.SECONDS)
        testSubscriber.assertValueCount(2)
    }
}