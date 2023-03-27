package com.ggjg.library.handler

import com.ggjg.library.exceion.*
import com.ggjg.library.handler.exceion.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend inline fun <T> GGJGApiCall(
    crossinline callFunction: suspend () -> T,
): T {
    return try {
        withContext(Dispatchers.IO) {
            callFunction()
        }
    } catch (e: HttpException) {
        throw when (e.code()) {
            400 -> MoreDataException()
            401 -> TokenErrorException()
            404 -> NotFoundException()
            409 -> ConflictException()
            else -> UnknownException()
        }
    } catch (e: NeedLoginException) {
        throw e
    }
}