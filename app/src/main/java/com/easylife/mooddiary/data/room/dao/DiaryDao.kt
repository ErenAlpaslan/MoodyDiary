package com.easylife.mooddiary.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.easylife.mooddiary.entity.DiaryNote

/**
 * Created by erenalpaslan on 17.09.2022
 */
@Dao
interface DiaryDao {

    @Insert
    suspend fun insertNewDiary(diary: DiaryNote)

    @Update
    suspend fun updateDiary(diary: DiaryNote)

    @Delete
    suspend fun deleteDiary(diary: DiaryNote)

    @Query("SELECT * FROM Notes WHERE date = :date")
    suspend fun getDiaryNotesByDate(date: String): List<DiaryNote>

    @Query("SELECT COUNT(*) FROM Notes WHERE date = :date")
    suspend fun getDiaryCountsByDate(date: String): Int
}