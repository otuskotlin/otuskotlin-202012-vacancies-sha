package ru.otus.vacancies.model

data class Vacancy(
    val id: String,
    val title: String,
    val specialization: String? = null,
    val cityName: CityName? = null,
    val salary: String? = null,
    val description: String? = null,
    val experience: Experience? = null,
    val schedule: Schedule? = null,
    val manager: String? = null
)
