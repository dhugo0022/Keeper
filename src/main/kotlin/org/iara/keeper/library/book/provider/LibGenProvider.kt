package org.iara.keeper.library.book.provider

import org.iara.keeper.library.book.Book
import org.iara.keeper.library.book.PaginatedBookProvider
import org.iara.keeper.library.query.FieldQuery
import java.lang.StringBuilder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class LibGenProvider : PaginatedBookProvider<FieldQuery<LibGenField>> {
    // Reference: https://github.com/dunn/libgen.js/blob/trunk/lib/search.js

    override val baseUrl: String = "https://libgen.is"
    override fun parse(html: String): Book {
        TODO("Not yet implemented")
    }

    override fun validateQueryString(query: String): Boolean {
        return query.length >= 2
    }

    override fun query(raw: FieldQuery<LibGenField>, page: Int): String {
        val builder = StringBuilder(baseUrl)

        // The requested query
        builder.append("/search.php?req=${URLEncoder.encode(raw.query, StandardCharsets.UTF_8.toString())}")

        // Detailed view in order to get book covers
        builder.append("&view=detailed")

        // The specific field to search for
        builder.append("&column=${(raw.field.column ?:LibGenColumn.DEF).parameterName}")

        if (raw.field.sort != null) {
            builder.append("&sort=${raw.field.sort.parameterName}")

            builder.append("&sortmode=${(raw.field.sortMode ?: LibGenSortMode.DESCENDING).parameterName}")
        }

        return builder.toString()
    }
}

class LibGenField(
    val column: LibGenColumn? = null,
    val sort: LibGenSort? = null,
    val sortMode: LibGenSortMode? = null
) {

    constructor(): this(null, null, null)

    class Builder {
        lateinit var column: LibGenColumn
        lateinit var sort: LibGenSort
        lateinit var sortMode: LibGenSortMode

        fun build(): LibGenField {
            return LibGenField(
                if (this::column.isInitialized) column else null,
                if (this::sort.isInitialized) sort else null,
                if (this::sortMode.isInitialized) sortMode else null
            )
        }
    }
}

/*
    search_in options: "def", "title", "author", "series",
    "publisher", "year", "identifier", "language", "md5",
    "tags"
*/
enum class LibGenColumn(
    val parameterName: String
) {
    DEF("def"),
    TITLE("title"),
    AUTHOR("author"),
    SERIES("series"),
    PUBLISHER("publisher"),
    YEAR("year"),
    ISBN("identifier"),
    LANGUAGE("language"),
    MD5("md5"),
    TAGS("tags")
}

/*
    sort_by options: "def", "title", "author, "publisher",
    "year", "pages", "language", "filesize", "extension"
*/

enum class LibGenSort(
    val parameterName: String
) {
    DEF("def"),
    TITLE("title"),
    AUTHOR("author"),
    PUBLISHER("publisher"),
    YEAR("year"),
    PAGES("pages"),
    LANGUAGE("language"),
    FILE_SIZE("filesize"),
    EXTENSION("extension")
}

enum class LibGenSortMode(
    val parameterName: String
) {
    DESCENDING("DESC"),
    ASCENDING("ASC")
}

fun libGenFieldOf(init: LibGenField.Builder.() -> Unit): LibGenField {
    val builder = LibGenField.Builder()
    init.invoke(builder)
    return builder.build()
}