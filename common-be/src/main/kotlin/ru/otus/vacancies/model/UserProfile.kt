package ru.otus.vacancies.model

data class UserProfile(
    val id: String,
    val phone: String? = null,
    val email: String,
    val name: String,
    val surname: String? = null,
    val cityName: CityName? = null,
    val specialization: String,
    val experience: Experience? = null,
    val description: String? = null,
    val skills: String? = null,
    val education: String? = null,
    val schedule: Schedule? = null
)