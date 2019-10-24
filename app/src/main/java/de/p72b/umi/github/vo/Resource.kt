package de.p72b.umi.github.vo

data class Resource<out T>(val status: Status, val data: T?, val message: String?)

enum class Status {
    SUCCESS,
    ERROR
}