package ru.otus.vacancies.transport.common

import kotlinx.serialization.Serializable

@Serializable
enum class RsStatus {
    OK,
    BAD_RQ,
    INTERNAL_ERROR
}
