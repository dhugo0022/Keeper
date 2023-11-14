package org.iara.keeper.library.book

import org.iara.keeper.library.DownloadUrl
import org.iara.keeper.library.Material

class Book(
    sourceUrl: String,
    title: String,
    downloadUrls: List<DownloadUrl>,
    authors: List<String>?,
    language: String?,
    publisher: String?,
    size: Long?,
    val coverImageUrl: String?,
    val isbn: String?,
    val md5: String?
) : Material(sourceUrl, title, downloadUrls, authors, language, publisher, size)