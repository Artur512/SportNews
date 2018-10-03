package performtest.com.news.domain.news
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import performtest.com.news.repository.entity.News
import performtest.com.news.repository.news.NewsRepository


@RunWith(MockitoJUnitRunner::class)
class NewsUseCaseImplTest {
    @Mock
    private
    lateinit var repository: NewsRepository

    @InjectMocks
    private
    lateinit var useCaseImpl: NewsUseCaseImpl

    private val news = listOf(News(), News())
    @Before
    fun setUp() {

    }

    @Test
    fun when_usecase_calls_repository_should_return_two_values() {
        given(repository.getNews()).willReturn(Single.just(news))
        useCaseImpl.getNews(Schedulers.trampoline(), Schedulers.trampoline())
                .test()
                .assertValue { it.size == 2 }
    }

    @Test
    fun when_usecase_calls_repository_should_return_error() {
        val error = Throwable()
        given(repository.getNews()).willReturn(Single.error(error))
        useCaseImpl.getNews(Schedulers.trampoline(), Schedulers.trampoline())
                .test()
                .assertError(error)
    }

}