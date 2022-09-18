package com.easylife.mooddiary.domain.repository

import com.easylife.mooddiary.entity.DiaryNote

/**
 * Created by erenalpaslan on 17.09.2022
 */
interface DiaryRepository {

    suspend fun getDiaryNotesByDate(date: String): List<DiaryNote>

    suspend fun insertDiaryNote(note: DiaryNote)

    suspend fun updateDiaryNote(note: DiaryNote)

    suspend fun removeDiaryNote(note: DiaryNote)

    suspend fun getDiaryNoteCountByDate(date: String): Int
}