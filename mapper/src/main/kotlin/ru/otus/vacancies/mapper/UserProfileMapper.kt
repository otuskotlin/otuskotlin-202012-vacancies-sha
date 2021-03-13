package ru.otus.vacancies.mapper

import common.takeIfNotBlank
import ru.otus.vacancies.model.CityName
import ru.otus.vacancies.model.Experience
import ru.otus.vacancies.model.Schedule
import ru.otus.vacancies.model.UserProfile
import ru.otus.vacancies.transport.CityNameDto
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.ScheduleDto
import ru.otus.vacancies.transport.rs.user.UserProfileDto

fun UserProfileDto.mapToModel(): UserProfile = UserProfile(
    id = this.id ?: "",
    phone = this.phone ?: "",
    email = this.email ?: "",
    name = this.name ?: "",
    surname = this.surname ?: "",
    cityName = CityName.values().find { it.name == this.cityName?.name } ?: CityName.NONE,
    specialization = this.specialization ?: "",
    experience = Experience.values().find { it.name == this.experience?.name } ?: Experience.NONE,
    description = this.description ?: "",
    skills = this.skills ?: "",
    education = this.education ?: "",
    schedule = Schedule.values().find { it.name == this.schedule?.name } ?: Schedule.NONE
)

fun UserProfile.mapToDto(): UserProfileDto = UserProfileDto(
    id = this.id.takeIfNotBlank(),
    phone = this.phone.takeIfNotBlank(),
    email = this.email.takeIfNotBlank(),
    name = this.name.takeIfNotBlank(),
    surname = this.surname.takeIfNotBlank(),
    cityName = CityNameDto.values().find { it.name == this.cityName.name },
    specialization = this.specialization.takeIfNotBlank(),
    experience = ExperienceDto.values().find { it.name == this.experience.name },
    description = this.description.takeIfNotBlank(),
    skills = this.skills.takeIfNotBlank(),
    education = this.education.takeIfNotBlank(),
    schedule = ScheduleDto.values().find { it.name == this.schedule.name }
)
