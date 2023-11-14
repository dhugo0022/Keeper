package org.iara.keeper.library

import org.iara.keeper.library.query.StringQuery

interface Query<Q : StringQuery> {

    /**
     * Validates if the given query string matches
     * the provider's condition and returns a
     * boolean indicating if it has passed or not
     *
     * @param query the query being validated
     * @return a boolean indicating if it has passed
     * or not
     */
    fun validateQueryString(query: String): Boolean
}