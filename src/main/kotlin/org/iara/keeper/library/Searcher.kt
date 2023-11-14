package org.iara.keeper.library

import org.iara.keeper.library.query.StringQuery

class Searcher<T : Material, Q : StringQuery>(
    private val provider: Provider<T, Q>
){

    fun search(query: Q) {

    }
}