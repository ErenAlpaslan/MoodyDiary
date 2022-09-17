package com.easylife.mooddiary.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by erenalpaslan on 17.09.2022
 */
@Entity(tableName = "Notes")
data class DiaryNote(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var moodId: Int?,
    var emotionId: Int?,
    var sphereOfLifeId: Int?,
    var title: String?,
    var description: String?,
    var createdAt: Long,
    var date: String
)
