package com.example.data.repository

import com.example.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

private const val NETWORK_ERROR_MESSAGE = "Couldn't reach to server, Please check you internet."


suspend fun <T> fetchApiData(
    response: T
): Flow<Resource<T>> {
    return flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: ""
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        } catch (e: Exception) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        }
    }


}