package com.example.data.repository

import com.example.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

private const val NETWORK_ERROR_MESSAGE = "Couldn't reach to server, Please check you internet."

abstract class HandleApiResponse {
    suspend fun <T, R> fetchApiData(
        response: suspend () -> T,
        mapper: (T) -> R
    ): Flow<Resource<R>> {
        return flow {
            try {
                emit(Resource.Loading())
                val result = mapper(response())
                emit(Resource.Success(result))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.localizedMessage
                    )
                )
            } catch (e: IOException) {
                emit(Resource.Error(NETWORK_ERROR_MESSAGE))
            }
        }
    }
}

