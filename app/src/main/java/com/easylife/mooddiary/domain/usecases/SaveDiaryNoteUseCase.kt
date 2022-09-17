package com.easylife.mooddiary.domain.usecases

import com.easylife.mooddiary.base.BaseUseCase
import com.easylife.mooddiary.domain.repository.DiaryRepository
import com.easylife.mooddiary.entity.DiaryNote
import com.easylife.mooddiary.entity.UserDiaryInput
import com.easylife.mooddiary.utils.dispatchers.MoodyDispatchers
import com.easylife.wallpaperapp.utils.AppResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

/**
 * Created by erenalpaslan on 17.09.2022
 */
class SaveDiaryNoteUseCase(
    private val diaryRepository: DiaryRepository,
    private val dispatchers: MoodyDispatchers
): BaseUseCase<Boolean, SaveDiaryNoteUseCase.Param>() {

    data class Param(
        val input: UserDiaryInput,
        val date: String
    )

    override suspend fun execute(params: Param): Flow<AppResult<Boolean>> = flow{
        try {
            val calendar = Calendar.getInstance()
            diaryRepository.insertDiaryNote(
                DiaryNote(
                    moodId = params.input.mood?.id,
                    emotionId = params.input.emotion?.id,
                    sphereOfLifeId = params.input.sphereOfLife?.id,
                    title = params.input.title,
                    description = params.input.description,
                    createdAt = calendar.timeInMillis,
                    date = params.date,
                )
            )
            emit(AppResult.Success(true))
        }catch(e: Exception) {
            emit(AppResult.Error(message = e.message))
        }
    }.flowOn(dispatchers.io)

}