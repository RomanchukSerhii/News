package news_info

import org.simpleframework.xml.Serializer
import org.simpleframework.xml.core.Persister
import pojo.NewsResponse
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class XmlNewsInfo(baseUrl: String) : NewsInfo(baseUrl) {

    override fun loadNews(baseUrl: String): NewsResponse? {
        return try {
            val url = URL(baseUrl)
            val connection = url.openConnection() as (HttpURLConnection)
            val apiResponse = connection.inputStream.bufferedReader().readText()

            val serializer: Serializer = Persister()
            return serializer.read(NewsResponse::class.java, apiResponse)
        } catch (e: IOException) {
            println("Новости не загрузились! Ошибка - ${e.message}")
            null
        }
    }
}