package ru.otus.vacancies.transport

import kotlinx.serialization.json.Json
import ru.otus.vacancies.transport.rq.vacancy.GetVacancyRq
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class GetVacancyRqTest {

    @Test
    fun serialize() {
        val rq = GetVacancyRq(ids = listOf("1", "2"))
        val json = Json
        val rqJson = json.encodeToString(GetVacancyRq.serializer(), rq)
        assertTrue(rqJson.contains("{\"ids\":[\"1\",\"2\"]}"))
        val rqDes = json.decodeFromString(GetVacancyRq.serializer(), rqJson)
        assertEquals(rq, rqDes)
    }
}