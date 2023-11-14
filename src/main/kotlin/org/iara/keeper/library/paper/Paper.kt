package org.iara.keeper.library.paper

import org.iara.keeper.library.DownloadUrl
import org.iara.keeper.library.Material

/*
    TODO: check if the Paper object really needs the following fields:
    - language;
    - publisher;
*/
class Paper(
    sourceUrl: String,
    title: String,
    downloadUrls: List<DownloadUrl>,
    authors: List<String>?,
    language: String?,
    publisher: String?,
    size: Long?
) : Material(sourceUrl, title, downloadUrls, authors, language, publisher, size)