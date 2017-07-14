package nl.sourcelabs.solutions.kotlinworkshop.util

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource

fun params(params: (params: MapSqlParameterSource) -> Unit): MapSqlParameterSource {
    val map = MapSqlParameterSource()
    params(map)
    return map
}