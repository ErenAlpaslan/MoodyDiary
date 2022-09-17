package com.easylife.mooddiary.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easylife.mooddiary.data.room.dao.DiaryDao
import com.easylife.mooddiary.entity.DiaryNote

@Database(
    entities = [
        DiaryNote::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun diaryDao(): DiaryDao

}