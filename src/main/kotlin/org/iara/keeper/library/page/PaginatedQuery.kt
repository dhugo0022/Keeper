package org.iara.keeper.library.page

import org.iara.keeper.library.Query
import org.iara.keeper.library.query.StringQuery

interface PaginatedQuery<Q : StringQuery> : Query<Q> {

    /**
     * Converts the given query to the provider's
     * specific request url in a selected page.
     *
     * If the provider doesn't pagination, the
     * page field won't matter, so it's a good
     * practice to use the [query] instead
     *
     * @param raw the query input
     * @return the page-specific request url as a string
     */
    fun query(raw: Q, page: Int): String
}