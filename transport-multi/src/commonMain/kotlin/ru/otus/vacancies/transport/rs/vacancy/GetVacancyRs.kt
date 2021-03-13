package ru.otus.vacancies.transport.rs.vacancy

import kotlinx.serialization.Serializable
import ru.otus.vacancies.transport.common.IMpRs
import ru.otus.vacancies.transport.common.RsError
import ru.otus.vacancies.transport.common.RsStatus

@Serializable
data class GetVacancyRs(
    override val rqUid: String? = null,
    override val rsUid: String? = null,
    override val rsTm: String? = null,
    override val status: RsStatus? = null,
    override val errors: List<RsError>? = null,
    val vacancies: List<VacancyDto>? = null
) : IMpRs