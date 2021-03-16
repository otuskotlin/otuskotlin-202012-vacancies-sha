package ru.otus.vacancies.spring.controller

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.vacancies.transport.common.RsStatus
import ru.otus.vacancies.transport.rq.vacancy.CreateVacancyRq
import ru.otus.vacancies.transport.rq.vacancy.DeleteVacancyRq
import ru.otus.vacancies.transport.rq.vacancy.GetVacancyRq
import ru.otus.vacancies.transport.rq.vacancy.UpdateVacancyRq
import ru.otus.vacancies.transport.rs.vacancy.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/vacancy")
class VacancyController {

    @PostMapping("/get")
    fun get(@RequestBody rq: GetVacancyRq): ResponseEntity<GetVacancyRs> =
        ResponseEntity.ok(
            GetVacancyRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK,
                vacancies = listOf(
                    VacancyDto(
                        id = "1",
                        title = "superVacancy"
                    )
                )
            )
        )

    @PostMapping("/create")
    fun create(@RequestBody rq: CreateVacancyRq): ResponseEntity<CreateVacancyRs> =
        ResponseEntity.ok(
            CreateVacancyRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK
            )
        )

    @PostMapping("/update")
    fun update(@RequestBody rq: UpdateVacancyRq): ResponseEntity<UpdateVacancyRs> =
        ResponseEntity.ok(
            UpdateVacancyRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK
            )
        )

    @PostMapping("/delete")
    fun delete(@RequestBody rq: DeleteVacancyRq): ResponseEntity<DeleteVacancyRs> =
        ResponseEntity.ok(
            DeleteVacancyRs(
                rqUid = rq.rqUid,
                rsTm = LocalDateTime.now().toString(),
                rsUid = RandomStringUtils.randomAlphanumeric(16),
                status = RsStatus.OK,
                ids = rq.ids
            )
        )
}