package ru.otus.vacancies.spring.controller

import kotlinx.serialization.json.Json
import org.hamcrest.CoreMatchers.containsString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import ru.otus.vacancies.transport.rq.vacancy.GetVacancyRq
import kotlin.test.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import ru.otus.vacancies.transport.rq.vacancy.CreateVacancyRq
import ru.otus.vacancies.transport.rq.vacancy.DeleteVacancyRq
import ru.otus.vacancies.transport.rq.vacancy.UpdateVacancyRq

@WebMvcTest(VacancyController::class)
class VacancyControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun get() {
        val json = Json
        val rq = GetVacancyRq()
        val rqJson = json.encodeToString(GetVacancyRq.serializer(), rq)
        mockMvc
            .perform(
                post("/vacancy/get")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                status().isOk
            ).andExpect(content().string(containsString("\"title\":\"superVacancy\"")))
    }

    @Test
    fun create() {
        val json = Json
        val rq = CreateVacancyRq(title = "Senior Kotlin developer")
        val rqJson = json.encodeToString(CreateVacancyRq.serializer(), rq)
        mockMvc
            .perform(
                post("/vacancy/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                status().isOk
            ).andExpect(content().string(containsString("\"status\":\"OK\"")))
    }

    @Test
    fun update() {
        val json = Json
        val rq = UpdateVacancyRq(id = "1", rqUid = "123")
        val rqJson = json.encodeToString(UpdateVacancyRq.serializer(), rq)
        mockMvc
            .perform(
                post("/vacancy/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                status().isOk
            ).andExpect(content().string(containsString("\"rqUid\":\"123\"")))
    }

    @Test
    fun delete() {
        val json = Json
        val rq = DeleteVacancyRq(ids = listOf("543"))
        val rqJson = json.encodeToString(DeleteVacancyRq.serializer(), rq)
        mockMvc
            .perform(
                post("/vacancy/delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                status().isOk
            ).andExpect(content().string(containsString("\"ids\":[\"543\"]")))
    }
}
