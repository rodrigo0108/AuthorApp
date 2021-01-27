package com.heyoh.model.result

sealed class Failure {
    object NetworkConnection: Failure()
    object ServerError: Failure()
    object Unexpected: Failure()
    object ClientError: Failure()
}