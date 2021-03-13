package ru.otus.vacancies.spring.controller

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.vacancies.transport.common.RsStatus
import ru.otus.vacancies.transport.rq.user.CreateUserProfileRq
import ru.otus.vacancies.transport.rq.user.DeleteUserProfileRq
import ru.otus.vacancies.transport.rq.user.GetUserProfileRq
import ru.otus.vacancies.transport.rq.user.UpdateUserProfileRq
import ru.otus.vacancies.transport.rs.user.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/userProfile")
class UserProfileController {

    @PostMapping("/get")
    fun get(@RequestBody rq: GetUserProfileRq): ResponseEntity<GetUserProfileRs> =
        ResponseEntity.ok(
            GetUserProfileRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK,
                userProfiles = listOf(
                    UserProfileDto(
                        id = "1",
                        email = "someone@mail.ru",
                        name = "bestName",
                        specialization = "Java developer, " +
                                "too many variants to create separate entity"
                    )
                )
            )
        )

    @PostMapping("/create")
    fun create(@RequestBody rq: CreateUserProfileRq): ResponseEntity<CreateUserProfileRs> =
        ResponseEntity.ok(
            CreateUserProfileRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK
            )
        )

    @PostMapping("/update")
    fun update(@RequestBody rq: UpdateUserProfileRq): ResponseEntity<UpdateUserProfileRs> =
        ResponseEntity.ok(
            UpdateUserProfileRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK
            )
        )

    @PostMapping("/delete")
    fun delete(@RequestBody rq: DeleteUserProfileRq): ResponseEntity<DeleteUserProfileRs> =
        ResponseEntity.ok(
            DeleteUserProfileRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK,
                ids = listOf("1", "2", "5")
            )
        )
}