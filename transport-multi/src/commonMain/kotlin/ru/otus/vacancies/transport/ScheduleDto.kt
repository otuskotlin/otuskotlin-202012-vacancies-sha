package ru.otus.vacancies.transport

import kotlinx.serialization.Serializable

@Serializable
enum class ScheduleDto {
    FULL,
    PART_TIME,
    INTERNSHIP
}
