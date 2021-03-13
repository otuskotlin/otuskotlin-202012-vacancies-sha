package ru.otus.vacancies.transport.rq.user

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto
import ru.otus.vacancies.transport.common.IMpRq

@Serializable
data class UpdateUserProfileRq(
    override val rqUid: String?,
    override val rqTm: String?,
    val id: String,
    val phone: String?,
    val email: String,
    val name: String,
    val surname: String? = null,
    val cityName: CityNameDto? = null,
    val specialization: String,
    val experience: ExperienceDto?,
    val description: String?,
    val skills: String?,
    val education: String?,
    val schedule: ScheduleDto?
) : IMpRq