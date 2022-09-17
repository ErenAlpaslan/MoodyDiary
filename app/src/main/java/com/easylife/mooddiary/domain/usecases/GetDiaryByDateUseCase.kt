package com.easylife.mooddiary.domain.usecases

import com.easylife.mooddiary.base.BaseUseCase
import com.easylife.mooddiary.domain.repository.DiaryRepository
import com.easylife.mooddiary.entity.DiaryNote
import com.easylife.mooddiary.utils.dispatchers.MoodyDispatchers
import com.easylife.wallpaperapp.utils.AppResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by erenalpaslan on 17.09.2022
 */
class GetDiaryByDateUseCase(
    private val diaryRepository: DiaryRepository,
    private val dispatchers: MoodyDispatchers
): BaseUseCase<List<DiaryNote>, GetDiaryByDateUseCase.Param>() {

    data class Param(
        val date: String
    )

    override suspend fun execute(params: Param): Flow<AppResult<List<DiaryNote>>> = flow{
        try {
            val notes = diaryRepository.getDiaryNotesByDate(params.date)
            emit(AppResult.Success(notes))
        }catch(e: Exception) {
            emit(AppResult.Error(message = e.message))
        }
    }.flowOn(dispatchers.io)

}