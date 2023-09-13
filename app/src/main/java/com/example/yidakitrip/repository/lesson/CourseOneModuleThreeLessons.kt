package com.example.yidakitrip.repository.lesson

import com.example.yidakitrip.R
import com.example.yidakitrip.items.LessonElement
import com.example.yidakitrip.model.LessonContent

class CourseOneModuleThreeLessons {
    fun lessonOneList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "Модуль 3 УРОК 1"
            ),
            LessonContent (
                type = LessonElement.TEXT,
                text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
            ),
            LessonContent (
                type = LessonElement.IMAGE,
                text = R.drawable.img_lesson_c1m1l1_1.toString()
            )
        )
    }
    fun lessonTwoList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "Модуль 3 УРОК 2"
            ),
            LessonContent (
                type = LessonElement.IMAGE,
                text = R.drawable.img_lesson_c1m1l1_1.toString()
            )
        )
    }
    fun lessonThreeList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "Модуль 3 УРОК 3"
            ),
            LessonContent (
                type = LessonElement.IMAGE,
                text = R.drawable.img_lesson_c1m1l1_1.toString()
            )
        )
    }
}