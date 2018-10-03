package performtest.com.news.domain.standings

import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import performtest.com.news.repository.entity.Ranking
import performtest.com.news.repository.standings.StandingsRepository
@RunWith(MockitoJUnitRunner::class)
class StandingsUseCaseImplTest {
    @Mock
    private
    lateinit var repository: StandingsRepository

    @InjectMocks
    private
    lateinit var useCaseImpl: StandingsUseCaseImpl

    private val rankings = listOf(Ranking())
    @Before
    fun setUp() {
        given(repository.getStandings()).willReturn(Single.just(rankings))
    }

    @Test
    fun when_usecase_calls_repository_should_return_one_value() {
        useCaseImpl.getStandings(Schedulers.trampoline(), Schedulers.trampoline())
                .test()
                .assertValue { it.size == 1 }
    }

    @Test
    fun when_usecase_calls_repository_should_return_error() {
        val error = Throwable()
        given(repository.getStandings()).willReturn(Single.error(error))
        useCaseImpl.getStandings(Schedulers.trampoline(), Schedulers.trampoline())
                .test()
                .assertError(error)
    }

}

