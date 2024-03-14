package com.example.data.repository

import com.example.domain.Resource
import retrofit2.HttpException
import retrofit2.Response

private const val NETWORK_ERROR_MESSAGE = "Couldn't reach to server, Please check you internet."

abstract class HandleApiResponse {
    suspend fun <T, R> fetchApiData(
        response: suspend () -> Response<T>,
        mapper: (T) -> R
    ): Resource<R> {
        try {
            val result = response()
            return if (result.isSuccessful && result.body() != null) {
                Resource.Success(mapper(result.body()!!))
            } else {
                Resource.Error(NETWORK_ERROR_MESSAGE)
            }

        } catch (e: HttpException) {
            return Resource.Error(
                e.localizedMessage
            )
        } catch (e: Exception) {
            return Resource.Error(NETWORK_ERROR_MESSAGE)
        }

    }
}

