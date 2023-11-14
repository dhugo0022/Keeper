package org.iara.keeper.library

import org.iara.keeper.library.query.StringQuery

// TODO: create a SinglePageSearch and PaginatedSearch that extends from this class
class Search<T : Material, Q : StringQuery>(
    val raw: Q,
) {


}
