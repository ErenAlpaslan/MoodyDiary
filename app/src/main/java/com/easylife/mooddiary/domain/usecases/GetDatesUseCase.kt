package com.easylife.mooddiary.domain.usecases

import com.easylife.mooddiary.base.BaseUseCase
import com.easylife.mooddiary.domain.repository.DateRepository
import com.easylife.mooddiary.entity.SingleDatePoint
import com.easylife.mooddiary.utils.dispatchers.MoodyDispatchers
import com.easylife.wallpaperapp.utils.AppResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 14.09.2022
 */
class GetDatesUseCase(
    private val dateRepository: DateRepository,
    private val dispatchers: MoodyDispatchers
): BaseUseCase<List<SingleDatePoint>, GetDatesUseCase.Param>() {
    data class Param(
        val year: String
    )

    override suspend fun execute(params: Param): Flow<AppResult<List<SingleDatePoint>>> = flow{
        try {
            emit(AppResult.Success(dateRepository.createDatesOfTheYear()))
        }catch (e: Exception) {
            emit(AppResult.Error(e.message))
        }
    }.flowOn(dispatchers.io)
}