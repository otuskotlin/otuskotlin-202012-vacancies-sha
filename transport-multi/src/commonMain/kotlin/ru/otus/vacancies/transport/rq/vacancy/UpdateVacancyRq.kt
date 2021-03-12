package ru.otus.vacancies.transport.rq.vacancy

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto
import ru.otus.vacancies.transport.common.IMpRq

@Serializable
data class UpdateVacancyRq(
    override val rqUid: String?,
    override val rqTm: String?,
    val id: String,
    val title: String?,
    val specialization: String?,
    val city: CityDto?,
    val salary: String?,
    val description: String?,
    val experience: ExperienceDto?,
    val schedule: ScheduleDto?,
    val manager: String?
) : IMpRq