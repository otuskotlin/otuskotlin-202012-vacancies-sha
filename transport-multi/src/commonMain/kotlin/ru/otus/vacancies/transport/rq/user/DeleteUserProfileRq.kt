package ru.otus.vacancies.transport.rq.user

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.common.IMpRq

@Serializable
data class DeleteUserProfileRq(
    override val rqUid: String,
    override val rqTm: String,
    val id: List<String>
) : IMpRq