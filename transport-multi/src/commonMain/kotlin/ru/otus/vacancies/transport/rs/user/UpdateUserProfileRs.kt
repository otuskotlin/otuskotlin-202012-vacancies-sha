package ru.otus.vacancies.transport.rs.user

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.common.IMpRs
import ru.otus.vacancies.transport.common.RsError
import ru.otus.vacancies.transport.common.RsStatus

@Serializable
data class UpdateUserProfileRs(
    override val rqUid: String? = null,
    override val rsUid: String? = null,
    override val rsTm: String? = null,
    override val status: RsStatus? = null,
    override val errors: List<RsError>? = null,
    val ids: List<String>? = null
) : IMpRs