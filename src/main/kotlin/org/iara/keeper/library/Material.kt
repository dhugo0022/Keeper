package org.iara.keeper.library

open class Material(
    val sourceUrl: String,
    val title: String,
    val downloadUrls: List<DownloadUrl>,
    val authors: List<String>?,
    val language: String?,
    val publisher: String?,
    val size: Long?
)