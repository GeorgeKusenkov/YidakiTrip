package com.example.yidakitrip.repository.module

import com.example.yidakitrip.model.ModuleItemList

class ModulesRepository {
    fun getCourseOneModules(): List<ModuleItemList> {
        return listOf(
            ModuleItemList(
                id = "MODULE-1",
                title = "Модуль 1",
                description = "Изучите основы игры на диджериду",
                image = 1
            ),
            ModuleItemList(
                id = "MODULE-2",
                title = "Модуль 2",
                description = "Как играть ритмы? Новое путешествие Луки",
                image = 1
            ),
            ModuleItemList(
                id = "MODULE-3",
                title = "Модуль 3",
                description = "Научитесь играть циркулярным дыханим. Вы отправитесь в пещеру, чтобы узнать это",
                image = 1
            ),
            ModuleItemList(
                id = "MODULE-4",
                title = "Модуль 4",
                description = "Научитесь играть ритмами. Заставьте племя танцевать",
                image = 1
            )
        )
    }

    fun getCourseTwoModules(): List<ModuleItemList> {
        return listOf(
            ModuleItemList(
                id = "MODULE-1",
                title = "Module One",
                description = "learn about didgeridoo and Really I was searching for this tutorial for a long time, thank you for this gift",
                image = 1
            ),
            ModuleItemList(
                id = "2",
                title = "MODULE-2",
                description = "HOW can we use an items (from our layout resources) and insert them between the sticky headers too ?",
                image = 1
            ),
            ModuleItemList(
                id = "MODULE-3",
                title = "Module One",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks",
                image = 1
            )
        )
    }
}