package common

fun String.takeIfNotBlank() = this.takeIf { it.isNotBlank() }
