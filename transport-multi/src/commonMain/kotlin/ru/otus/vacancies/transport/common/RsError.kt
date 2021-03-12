package ru.otus.vacancies.transport.common

import kotlinx.serialization.Serializable

@Serializable
data class RsError(
    val code: String? = null,
    val message: String? = null
)