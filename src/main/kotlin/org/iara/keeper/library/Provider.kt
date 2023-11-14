package org.iara.keeper.library

import org.iara.keeper.library.query.StringQuery

interface Provider<T : Material, Q : StringQuery> : Query<Q> {

    /**
     * The provider's specific base url
     * used to create the request for
     * the material
     */
    val baseUrl: String

    /**
     * Parses the given html code into
     * the provider's data object
     */
    fun parse(html: String): T
}