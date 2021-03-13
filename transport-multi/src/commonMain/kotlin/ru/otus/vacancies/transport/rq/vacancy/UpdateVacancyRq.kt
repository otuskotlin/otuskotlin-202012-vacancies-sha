package ru.otus.vacancies.transport.rq.vacancy

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto
import ru.otus.vacancies.transport.common.IMpRq

@Serializable
data class UpdateVacancyRq(
    override val rqUid: String? = null,
    override val rqTm: String? = null,
    val id: String,
    val title: String? = null,
    val specialization: String? = null,
    val cityName: CityNameDto? = null,
    val salary: String? = null,
    val description: String? = null,
    val experience: ExperienceDto? = null,
    val schedule: ScheduleDto? = null,
    val manager: String? = null
) : IMpRq