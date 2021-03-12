package ru.otus.vacancies.transport.rs.vacancy

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.common.IMpRs
import ru.otus.vacancies.transport.common.RsError
import ru.otus.vacancies.transport.common.RsStatus

@Serializable
data class CreateVacancyRs(
    override val rqUid: String,
    override val rsUid: String,
    override val rsTm: String,
    override val status: RsStatus,
    override val errors: List<RsError> = emptyList(),
    val ids: List<String> = emptyList()
) : IMpRs
