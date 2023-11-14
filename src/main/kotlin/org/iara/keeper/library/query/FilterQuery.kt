package org.iara.keeper.library.query

import okhttp3.internal.toImmutableMap
import java.util.EnumMap
import kotlin.reflect.KClass

class FilterQuery<F : Enum<F>>(filterEnum: KClass<F>, query: String): StringQuery(query) {

    private val filterMap: EnumMap<F, String> = EnumMap(filterEnum.java)

    fun filter(parameter: F, value: String) {
        filterMap[parameter] = value
    }

    infix fun F.filterTo(value: String) {
        filterMap[this] = value
    }

    fun filters() = filterMap.toImmutableMap()
}

inline fun <reified F : Enum<F>> filterQueryOf(query: String, init: FilterQuery<F>.() -> Unit): FilterQuery<F> {
    val filterQuery = FilterQuery(F::class, query)
    init.invoke(filterQuery)
    return filterQuery
}