package ru.otus.vacancies.transport.rs.user

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto

@Serializable
data class UserProfileDto(
    val id: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val cityName: CityNameDto? = null,
    val specialization: String? = null,
    val experience: ExperienceDto? = null,
    val description: String? = null,
    val skills: String? = null,
    val education: String? = null,
    val schedule: ScheduleDto? = null
)
