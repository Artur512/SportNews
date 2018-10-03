package performtest.com.news.repository.news

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
import performtest.com.news.repository.entity.News
import performtest.com.news.repository.entity.NewsResponse
import performtest.com.news.repository.entity.RssNews

@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryImplTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    @Mock
    private lateinit var api: SportNewsApi
    @InjectMocks
    private lateinit var repository: NewsRepositoryImpl
    private var newsResponse = arrayListOf(News(), News())
    private var response = RssNews(response = NewsResponse(newsData = newsResponse))

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        given(api.getNewsList()).willReturn(Single.just(response))
    }

    @Test
    fun when_get_rss_news_return_list_of_news() {
        repository.getNews()
                .test()
                .assertValue(newsResponse)
    }
}