package performtest.com.news.ui.news

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import performtest.com.news.domain.news.NewsUseCase
import performtest.com.news.repository.entity.News

@RunWith(MockitoJUnitRunner::class)
class NewsViewModelTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    private lateinit var useCase: NewsUseCase
    @InjectMocks
    private lateinit var viewModel: NewsViewModel

    private val news = News()
    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        given(useCase.getNews()).willReturn(Single.just(listOf(news)))
    }

    @Test
    fun when_get_news_append_it_to_live_data_variable() {
        viewModel.getNews()
        verify(useCase).getNews()
        assertEquals(mutableListOf(news), viewModel.news.value)

    }

}