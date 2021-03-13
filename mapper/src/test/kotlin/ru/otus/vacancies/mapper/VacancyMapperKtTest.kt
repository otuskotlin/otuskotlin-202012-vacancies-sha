package ru.otus.vacancies.mapper

import ru.otus.vacancies.model.Vacancy
import ru.otus.vacancies.transport.ExperienceDto
import ru.otus.vacancies.transport.rs.vacancy.VacancyDto
import kotlin.test.Test
import kotlin.test.assertEquals

class VacancyMapperKtTest {

    @Test
    fun mapToModel() {
        val dto = VacancyDto(
            id = "1",
            title = "title",
            experience = ExperienceDto.MORE_THAN_SIX
        )
        val model = dto.mapToModel()
        assertEquals(model.experience?.name, dto.experience?.name)
    }

    @Test
    fun mapToDto() {
        val model = Vacancy(
            id = "1",
            title = "title",
        )
        val dto = model.mapToDto()
        assertEquals(model.title, dto.title)
    }
}
