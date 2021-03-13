package ru.otus.vacancies.transport.common

interface IMpRs {
    val rqUid: String?
    val rsUid: String?
    val rsTm: String?
    val status: RsStatus?
    val errors: List<RsError>?
}