package com.example.yidakitrip.repository

import com.example.yidakitrip.model.LessonsItemList

class TestModules {
    fun getModule(id: Int):List<LessonsItemList> {
        return when(id) {
            1 -> listOf(
                LessonsItemList(
                    title = "Урок 1",
                    description = "Введение",
                    image = 1
                ),
                LessonsItemList(
                    title = "Урок 2",
                    description = "Знакомство с персонажами",
                    image = 1
                ),
                LessonsItemList(
                    title = "Урок 3",
                    description = "Путешествие в деревню",
                    image = 1
                ),
                LessonsItemList(
                    title = "Урок 4",
                    description = "Встреча с шаманом",
                    image = 1
                ),
                LessonsItemList(
                    title = "Урок 5",
                    description = "Начало обучения",
                    image = 1
                )
            )   //Lessons of Module 1
            2 -> listOf(
                LessonsItemList(
                    title = "M2 Урок 1",
                    description = "Введение",
                    image = 1
                ),
                LessonsItemList(
                    title = "M2 Урок 2",
                    description = "Знакомство с персонажами",
                    image = 1
                ),
                LessonsItemList(
                    title = "M2 Урок 3",
                    description = "Путешествие в деревню",
                    image = 1
                )
            )   //Lessons of Module 2
            3 -> listOf(
                LessonsItemList(
                    title = "M3 Урок 1",
                    description = "Введение",
                    image = 1
                ),
                LessonsItemList(
                    title = "M3 Урок 2",
                    description = "Знакомство с персонажами",
                    image = 1
                ),
                LessonsItemList(
                    title = "M3 Урок 3",
                    description = "Путешествие в деревню",
                    image = 1
                ),
                LessonsItemList(
                    title = "M3 Урок 4",
                    description = "Встреча с шаманом",
                    image = 1
                )
            )   //Lessons of Module 3
            else -> emptyList()
        }
    }


}