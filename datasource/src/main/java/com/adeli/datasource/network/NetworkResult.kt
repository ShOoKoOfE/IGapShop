package com.adeli.datasource.network

import com.adeli.core.domain.ProgressBarState

sealed class NetworkResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T>(val progressBarState: ProgressBarState = ProgressBarState.Idle) : NetworkResult<T>()
}
