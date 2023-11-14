package org.iara.keeper.library.page

import org.iara.keeper.library.Query
import org.iara.keeper.library.query.StringQuery

interface SinglePageQuery<Q : StringQuery> : Query<Q> {

    /**
     * Converts the given query to the provider's
     * specific request url
     *
     * @param raw the query input
     * @return the request url as a string
     */
    fun query(raw: Q): String
}