package ru.otus.vacancies.transport.rs.vacancy

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto

@Serializable
data class VacancyDto(
    val id: String,
    val title: String,
    val specialization: String? = null,
    val cityName: CityNameDto? = null,
    val salary: String? = null,
    val description: String? = null,
    val experience: ExperienceDto? = null,
    val schedule: ScheduleDto? = null,
    val manager: String? = null
)
