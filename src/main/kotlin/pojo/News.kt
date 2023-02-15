package pojo

import com.squareup.moshi.Json
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "element", strict = false)
data class News @JvmOverloads constructor(
    @Json(name = "id")
    @field:Element(name = "id", required = false)
    @param:Element(name = "id", required = false)
    val id: Int = -1,

    @Json(name = "title")
    @field:Element(name = "title", required = false)
    @param:Element(name = "title", required = false)
    val title: String = "No title",

    @Json(name = "description")
    @field:Element(name = "description", required = false)
    @param:Element(name = "description", required = false)
    val description: String = "Description does not exist",

    @Json(name = "date")
    @field:Element(name = "date", required = false)
    @param:Element(name = "date", required = false)
    val date: String = "No date",

    @Json(name = "keywords")
    @field:ElementList(name = "keywords", required = false)
    @param:ElementList(name = "keywords", required = false)
    val keywords: List<String> = listOf(),

    @Json(name = "visible")
    @field:Element(name = "visible", required = false)
    @param:Element(name = "visible", required = false)
    val visible: Boolean = true
)