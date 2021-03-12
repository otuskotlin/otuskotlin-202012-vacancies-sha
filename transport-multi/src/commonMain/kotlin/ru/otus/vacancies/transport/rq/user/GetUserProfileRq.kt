package ru.otus.vacancies.transport.rq.user

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.common.IMpRq

@Serializable
data class GetUserProfileRq(
    override val rqUid: String? = null,
    override val rqTm: String? = null,
    val ids: List<String> = emptyList()
) : IMpRq