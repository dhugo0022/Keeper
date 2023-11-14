package org.iara.keeper.library.paper

import org.iara.keeper.library.page.SinglePageProvider
import org.iara.keeper.library.query.StringQuery

interface PaperProvider<Q : StringQuery> : SinglePageProvider<Paper, Q>