package org.iara.keeper.library.query

class FieldQuery<F>(val field: F, query: String) : StringQuery(query)