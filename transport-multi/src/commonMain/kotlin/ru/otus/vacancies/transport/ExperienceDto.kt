package ru.otus.vacancies.transport

import kotlinx.serialization.Serializable

@Serializable
enum class ExperienceDto {
    LESS_THAN_ONE,
    ONE_TO_THREE,
    THREE_TO_SIX,
    MORE_THAN_SIX
}
