package com.easylife.mooddiary.data.repository

import com.easylife.mooddiary.data.room.dao.DiaryDao
import com.easylife.mooddiary.domain.repository.DiaryRepository
import com.easylife.mooddiary.entity.DiaryNote

/**
 * Created by erenalpaslan on 17.09.2022
 */
class DiaryRepositoryImpl(
    private val diaryDao: DiaryDao
): DiaryRepository {
    override suspend fun getDiaryNotesByDate(date: String): List<DiaryNote> {
        return diaryDao.getDiaryNotesByDate(date)
    }

    override suspend fun insertDiaryNote(note: DiaryNote) {
        diaryDao.insertNewDiary(note)
    }

    override suspend fun updateDiaryNote(note: DiaryNote) {
        diaryDao.updateDiary(note)
    }

    override suspend fun removeDiaryNote(note: DiaryNote) {
        diaryDao.deleteDiary(note)
    }

}