import news_info.JsonNewsInfo
import news_info.NewsInfo
import news_info.XmlNewsInfo

private const val JSON_BASE_URL = "https://api2.kiparo.com/static/it_news.json"
private const val XML_BASE_URL = "https://api2.kiparo.com/static/it_news.xml"
private const val FIRST_VARIANT = 1
private const val SECOND_VARIANT = 2

fun main() {
    println("Нажмите 1 что-бы скачать JSON, 2 - XML:")
    var answer = verificationAnswer()
    val newsInfo: NewsInfo = if (answer == FIRST_VARIANT) {
        JsonNewsInfo(JSON_BASE_URL)
    } else {
        XmlNewsInfo(XML_BASE_URL)
    }

    if (newsInfo.isNewsLoaded()) {
        println("1 - вывести все новости, 2 - поиск по keyword")
        answer = verificationAnswer()
        if (answer == FIRST_VARIANT) {
            newsInfo.printNews()
        } else {
            println("Введите keyword:")
            val keyword = readln()
            newsInfo.printNews(keyword)
        }
    }
}

fun verificationAnswer() : Int {
    var answer: Int = 0
    var isCheck = true
    while (isCheck) {
        try {
            answer = readln().toInt()
            if (answer == FIRST_VARIANT || answer == SECOND_VARIANT) {
                isCheck = false
            } else throw RuntimeException()
        } catch (e: RuntimeException) {
            println("Неправильный ввод! Введите число 1 или 2:")
        }
    }
    return answer
}


