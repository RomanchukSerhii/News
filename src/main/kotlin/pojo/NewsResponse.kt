package pojo

import com.squareup.moshi.Json
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name="root", strict = false)
data class NewsResponse (
    @field:Element(name = "location", required = false)
    @param:Element(name = "location", required = false)
    val location: String,

    @field:Element(name = "name", required = false)
    @param:Element(name = "name", required = false)
    val name: String,

    @Json(name = "news")
    @field:ElementList(name = "news", required = false)
    @param:ElementList(name = "news", required = false)
    val news: List<News>
)