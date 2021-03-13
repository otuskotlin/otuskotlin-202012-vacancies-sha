package ru.otus.vacancies.mapper

import ru.otus.vacancies.model.CityName
import ru.otus.vacancies.model.Experience
import ru.otus.vacancies.model.Schedule
import ru.otus.vacancies.model.Vacancy
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto
import ru.otus.vacancies.transport.rs.vacancy.VacancyDto

fun VacancyDto.mapToModel(): Vacancy = Vacancy(
    id = this.id,
    title = this.title,
    specialization = this.specialization,
    cityName = CityName.values().find { it.name == this.cityName?.name },
    salary = this.salary,
    description = this.description,
    experience = Experience.values().find { it.name == this.experience?.name },
    schedule = Schedule.values().find { it.name == this.schedule?.name },
    manager = this.manager
)

fun Vacancy.mapToDto(): VacancyDto = VacancyDto(
    id = this.id,
    title = this.title,
    specialization = this.specialization,
    cityName = CityNameDto.values().find { it.name == this.cityName?.name },
    salary = this.salary,
    description = this.description,
    experience = ExperienceDto.values().find { it.name == this.experience?.name },
    schedule = ScheduleDto.values().find { it.name == this.schedule?.name },
    manager = this.manager
)


