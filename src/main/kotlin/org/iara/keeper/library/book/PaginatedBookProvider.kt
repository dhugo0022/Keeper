package org.iara.keeper.library.book

import org.iara.keeper.library.page.PaginatedProvider
import org.iara.keeper.library.query.StringQuery

interface PaginatedBookProvider<Q : StringQuery> : PaginatedProvider<Book, Q>