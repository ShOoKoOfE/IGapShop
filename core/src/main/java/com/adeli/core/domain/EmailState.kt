package com.adeli.core.domain

sealed class EmailState{
    object Reject: EmailState()
    object Accept: EmailState()
}
