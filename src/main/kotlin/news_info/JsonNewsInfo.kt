package news_info

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import pojo.NewsResponse
import java.io.IOException
import java.lang.NullPointerException
import java.net.HttpURLConnection
import java.net.URL

class JsonNewsInfo(baseUrl: String) : NewsInfo(baseUrl) {

    override fun loadNews(baseUrl: String): NewsResponse? {
        return try {
            val url = URL(baseUrl)
            val connection = url.openConnection() as (HttpURLConnection)
            val apiResponse = connection.inputStream.bufferedReader().readText()

            val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<NewsResponse> = moshi.adapter(NewsResponse::class.java)

            jsonAdapter.fromJson(apiResponse) ?: throw NullPointerException()
        } catch (e: IOException) {
            println("Новости не загрузились! Ошибка - ${e.message}")
            null
        }
    }
}