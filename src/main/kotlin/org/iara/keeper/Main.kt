package org.iara.keeper

import org.iara.keeper.library.Searcher
import org.iara.keeper.library.book.provider.LibGenColumn
import org.iara.keeper.library.book.provider.LibGenField
import org.iara.keeper.library.query.FieldQuery
import org.iara.keeper.library.query.fieldQueryOf

fun main(args: Array<String>) {
//    val searcher = Searcher()
    FieldQuery(LibGenField(LibGenColumn.TITLE), "d")

}