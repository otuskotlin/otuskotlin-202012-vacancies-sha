package ru.otus.vacancies.model

data class UserProfile(
    val id: String = "",
    val phone: String = "",
    val email: String = "",
    val name: String = "",
    val surname: String = "",
    val cityName: CityName = CityName.NONE,
    val specialization: String = "",
    val experience: Experience = Experience.NONE,
    val description: String = "",
    val skills: String = "",
    val education: String = "",
    val schedule: Schedule = Schedule.NONE
)