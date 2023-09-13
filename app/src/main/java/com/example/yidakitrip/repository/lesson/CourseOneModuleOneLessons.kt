package com.example.yidakitrip.repository.lesson

import com.example.yidakitrip.R
import com.example.yidakitrip.items.LessonElement
import com.example.yidakitrip.model.LessonContent

class CourseOneModuleOneLessons {
    fun lessonOneList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его. Впереди простиралась красная, бесконечная пустыня, горячий воздух обволакивал тело."
            ),
            LessonContent (
                type = LessonElement.LUKA,
                text = "Ничего не помню… Как я тут оказался?"
            ),
            LessonContent (
                type = LessonElement.TEXT,
                text = "Лука медленно побрёл вперед. Зелёная растительность постепенно начала разбавлять пустынную местность. Внезапно на горизонте показались 2 мужские фигуры. Они двигались навстречу."
            ),
            LessonContent (
                type = LessonElement.TEXT,
                text = "“Хм… похоже, это аборигены” - подумал Лука, чуть лучше разглядев их. Один из них высокий и худощавый, с  красной набедренной повязкой, на теле узоры из белой краски, а в правой руке он нес копьё. Второй поменьше ростом с  недлинными кучерявыми волосами и с набедренной повязкой из листьев.\n"
            ),
            LessonContent (
                type = LessonElement.LUKA,
                text = "Здравствуйте! Меня зовут Лука, вы не подскажете где это я? – прервал молчание Лука"
            ),
            LessonContent (
                type = LessonElement.TEXT,
                text = "Аборигены переглянулись и худощавый ответил"
            ),
            LessonContent (
                type = LessonElement.VARU,
                text = "Привет, Лука. Я Вару, а это Валу. Что ты делаешь в «пустыне раскалённой пустоты»?"
            ),
            LessonContent (
                type = LessonElement.LUKA,
                text = "Я не знаю. Ничего не могу вспомнить."
            ),
            LessonContent (
                type = LessonElement.VARU,
                text = "Тебе не стоит тут находиться! Наше поселение расположено неподалеку отсюда. Пойдём  с нами и мы подумаем, как помочь тебе."
            ),
            LessonContent (
                type = LessonElement.VARU,
                text = "Всё будет хорошо, пойдём."
            ),
            LessonContent (
                type = LessonElement.TEXT,
                text = "Лука, Вару и Валу отправились в деревню аборигенов."
            )
        )
    }
    fun lessonTwoList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "УРОК 2"
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
    fun lessonThreeList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "УРОК 3"
            ),
            LessonContent (
                type = LessonElement.IMAGE,
                text = R.drawable.img_lesson_c1m1l1_1.toString()
            )
        )
    }
    fun lessonFourList(): List<LessonContent> {
        return listOf(
            LessonContent (
                type = LessonElement.TEXT,
                text = "УРОК 4"
            ),
            LessonContent (
                type = LessonElement.IMAGE,
                text = R.drawable.img_lesson_c1m1l1_1.toString()
            )
        )
    }
}