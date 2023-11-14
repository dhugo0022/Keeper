package org.iara.keeper.library.paper.provider

import org.iara.keeper.library.paper.Paper
import org.iara.keeper.library.paper.PaperProvider
import org.iara.keeper.library.query.StringQuery

class SciHubProvider: PaperProvider<StringQuery> {
    // Sci-Hub only accepts URL, PMID, DOI or the title of the paper

    // TODO: Update Sci-Hub baseUrl
    override val baseUrl: String = ""
    override fun parse(html: String): Paper {
        TODO("Not yet implemented")
    }

    override fun query(raw: StringQuery): String {
        TODO("Not yet implemented")
    }

    override fun validateQueryString(query: String): Boolean {
        TODO("Not yet implemented")
    }
}