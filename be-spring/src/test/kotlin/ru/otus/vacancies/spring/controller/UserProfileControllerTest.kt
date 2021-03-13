package ru.otus.vacancies.spring.controller

import kotlinx.serialization.json.Json
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import ru.otus.vacancies.transport.rq.user.CreateUserProfileRq
import ru.otus.vacancies.transport.rq.user.DeleteUserProfileRq
import ru.otus.vacancies.transport.rq.user.GetUserProfileRq
import ru.otus.vacancies.transport.rq.user.UpdateUserProfileRq

@WebMvcTest(UserProfileController::class)
class UserProfileControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun get() {
        val json = Json
        val rq = GetUserProfileRq(ids = listOf("1"))
        val rqJson = json.encodeToString(GetUserProfileRq.serializer(), rq)
        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/userProfile/get")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                MockMvcResultMatchers.status().isOk
            ).andExpect(
                MockMvcResultMatchers.content().string(CoreMatchers.containsString("\"name\":\"bestName\""))
            )
    }

    @Test
    fun create() {
        val json = Json
        val rq = CreateUserProfileRq(
            email = "who@gmail.com",
            name = "someone",
            specialization = "DevOps"
        )
        val rqJson = json.encodeToString(CreateUserProfileRq.serializer(), rq)
        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/userProfile/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                MockMvcResultMatchers.status().isOk
            ).andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("\"status\":\"OK\"")))
    }

    @Test
    fun update() {
        val json = Json
        val rq =
            UpdateUserProfileRq(
                id = "1",
                email = "who@gmail.com",
                name = "someone",
                specialization = "DevOps",
                rqUid = "321"
            )
        val rqJson = json.encodeToString(UpdateUserProfileRq.serializer(), rq)
        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/userProfile/update")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                MockMvcResultMatchers.status().isOk
            ).andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("\"rqUid\":\"321\"")))
    }

    @Test
    fun delete() {
        val json = Json
        val rq = DeleteUserProfileRq(ids = listOf("876"))
        val rqJson = json.encodeToString(DeleteUserProfileRq.serializer(), rq)
        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/userProfile/delete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(rqJson)
            ).andExpect(
                MockMvcResultMatchers.status().isOk
            ).andExpect(MockMvcResultMatchers.content().string(CoreMatchers.containsString("\"ids\":[\"1\",\"2\",\"5\"]")))
    }
}
