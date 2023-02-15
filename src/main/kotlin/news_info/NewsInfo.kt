package news_info

import pojo.News
import pojo.NewsResponse
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class NewsInfo(baseUrl: String) {

    private var sortedNews = listOf<News>()

    abstract fun loadNews(baseUrl: String): NewsResponse?

    init {
        val newsResponse = this.loadNews(baseUrl)
        if (newsResponse != null) {
            sortedNews = getSortedNews(newsResponse)
            println("Новости успешно загрузились!")
        }
    }

    fun printNews() {
        if (isNewsLoaded()) {
            sortedNews.forEach { news -> print(news) }
        } else {
            println("Новости еще не были загружены!")
        }
    }

    fun printNews(keyword: String) {
        sortedNews = sortedNews.filter { it.keywords.contains(keyword) }
        printNews()
    }

    fun isNewsLoaded(): Boolean {
        return sortedNews.isNotEmpty()
    }

    private fun getSortedNews(newsResponse: NewsResponse): List<News> {
        return newsResponse.news.sortedBy { it.date }
    }

    private fun print(news: News) {
        val date = parseDate(news.date)
        println(news.title)
        println(news.description)
        println(date)
        println()
    }

    private fun parseDate(date: String): String{
        if (date == "") return date
        val dateInfo = date.split(" ")
        val parseDate = LocalDate.parse(dateInfo[0])
        val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        return parseDate.format(formatter)
    }
}