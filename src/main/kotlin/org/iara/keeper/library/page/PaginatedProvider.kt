package org.iara.keeper.library.page

import org.iara.keeper.library.Material
import org.iara.keeper.library.Provider
import org.iara.keeper.library.query.StringQuery

interface PaginatedProvider<T : Material, Q : StringQuery> : Provider<T, Q>, PaginatedQuery<Q>