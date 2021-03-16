package ru.otus.vacancies.model

data class Vacancy(
    val id: String = "",
    val title: String = "",
    val specialization: String = "",
    val cityName: CityName = CityName.NONE,
    val salary: String = "",
    val description: String = "",
    val experience: Experience = Experience.NONE,
    val schedule: Schedule = Schedule.NONE,
    val manager: String = ""
)
