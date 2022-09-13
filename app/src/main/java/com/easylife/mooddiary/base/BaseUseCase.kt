package com.easylife.mooddiary.base

import com.easylife.wallpaperapp.utils.AppResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by erenalpaslan on 14.08.2022
 */
abstract class BaseUseCase<T, R>() {
    abstract suspend fun execute(params: R): Flow<AppResult<T>>
}