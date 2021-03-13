package ru.otus.vacancies.transport.rq.user

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto
import ru.otus.vacancies.transport.common.IMpRq

@Serializable
data class UpdateUserProfileRq(
    override val rqUid: String? = null,
    override val rqTm: String? = null,
    val id: String,
    val phone: String? = null,
    val email: String,
    val name: String,
    val surname: String? = null,
    val cityName: CityNameDto? = null,
    val specialization: String,
    val experience: ExperienceDto? = null,
    val description: String? = null,
    val skills: String? = null,
    val education: String? = null,
    val schedule: ScheduleDto? = null
) : IMpRq