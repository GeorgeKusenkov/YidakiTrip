package com.example.yidakitrip.repository.lesson

import com.example.yidakitrip.R
import com.example.yidakitrip.items.LessonElement
import com.example.yidakitrip.model.Lesson
import com.example.yidakitrip.model.LessonContent

/**
First num - module, second num - lesson
EXAMPLE
16: Module 1 Lesson 5
116: Module 1 Lesson 16
 */
class LessonRepository {
    fun getLessons(id: Int): List<LessonContent> {
        return when (id) {
            11 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его. Впереди простиралась красная, бесконечная пустыня, горячий воздух обволакивал тело."
                ),
                LessonContent(
                    type = LessonElement.LUKA,
                    text = "Ничего не помню… Как я тут оказался?"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука медленно побрёл вперед. Зелёная растительность постепенно начала разбавлять пустынную местность. Внезапно на горизонте показались 2 мужские фигуры. Они двигались навстречу."
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "“Хм… похоже, это аборигены” - подумал Лука, чуть лучше разглядев их. Один из них высокий и худощавый, с  красной набедренной повязкой, на теле узоры из белой краски, а в правой руке он нес копьё. Второй поменьше ростом с  недлинными кучерявыми волосами и с набедренной повязкой из листьев.\n"
                ),
                LessonContent(
                    type = LessonElement.LUKA,
                    text = "Здравствуйте! Меня зовут Лука, вы не подскажете где это я? – прервал молчание Лука"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Аборигены переглянулись и худощавый ответил"
                ),
                LessonContent(
                    type = LessonElement.VARU,
                    text = "Привет, Лука. Я Вару, а это Валу. Что ты делаешь в «пустыне раскалённой пустоты»?"
                ),
                LessonContent(
                    type = LessonElement.LUKA,
                    text = "Я не знаю. Ничего не могу вспомнить."
                ),
                LessonContent(
                    type = LessonElement.VARU,
                    text = "Тебе не стоит тут находиться! Наше поселение расположено неподалеку отсюда. Пойдём  с нами и мы подумаем, как помочь тебе."
                ),
                LessonContent(
                    type = LessonElement.VARU,
                    text = "Всё будет хорошо, пойдём."
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука, Вару и Валу отправились в деревню аборигенов."
                )
            )   //Lesson 1 Module 1
            12 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "УРОК 2"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 2 Module 1
            13 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "УРОК 3"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 3 Module 1
            14 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "УРОК 4"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 4 Module 1

            21 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 2 УРОК 1"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 1 Module 2
            22 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 2 УРОК 2"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 2 Module 2
            23 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 2 УРОК 3"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 3 Module 2

            31 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 3 УРОК 1"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 1 Module 3
            32 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 3 УРОК 2"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 2 Module 3
            33 -> listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 3 УРОК 3"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            )   //Lesson 3 Module 3
            else -> emptyList()
        }
    }

    fun getNewLessons(id: Int): Lesson {
        return when (id) {
            11 -> Lesson(isFirstLesson = true, lessonContent = listOf(
                    LessonContent(
                        type = LessonElement.TEXT,
                        text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его. Впереди простиралась красная, бесконечная пустыня, горячий воздух обволакивал тело."
                    ),
                    LessonContent(
                        type = LessonElement.LUKA,
                        text = "Ничего не помню… Как я тут оказался?"
                    ),
                    LessonContent(
                        type = LessonElement.TEXT,
                        text = "Лука медленно побрёл вперед. Зелёная растительность постепенно начала разбавлять пустынную местность. Внезапно на горизонте показались 2 мужские фигуры. Они двигались навстречу."
                    ),
                    LessonContent(
                        type = LessonElement.TEXT,
                        text = "“Хм… похоже, это аборигены” - подумал Лука, чуть лучше разглядев их. Один из них высокий и худощавый, с  красной набедренной повязкой, на теле узоры из белой краски, а в правой руке он нес копьё. Второй поменьше ростом с  недлинными кучерявыми волосами и с набедренной повязкой из листьев.\n"
                    ),
                    LessonContent(
                        type = LessonElement.LUKA,
                        text = "Здравствуйте! Меня зовут Лука, вы не подскажете где это я? – прервал молчание Лука"
                    ),
                    LessonContent(
                        type = LessonElement.TEXT,
                        text = "Аборигены переглянулись и худощавый ответил"
                    ),
                    LessonContent(
                        type = LessonElement.VARU,
                        text = "Привет, Лука. Я Вару, а это Валу. Что ты делаешь в «пустыне раскалённой пустоты»?"
                    ),
                    LessonContent(
                        type = LessonElement.LUKA,
                        text = "Я не знаю. Ничего не могу вспомнить."
                    ),
                    LessonContent(
                        type = LessonElement.VARU,
                        text = "Тебе не стоит тут находиться! Наше поселение расположено неподалеку отсюда. Пойдём  с нами и мы подумаем, как помочь тебе."
                    ),
                    LessonContent(
                        type = LessonElement.VARU,
                        text = "Всё будет хорошо, пойдём."
                    ),
                    LessonContent(
                        type = LessonElement.TEXT,
                        text = "Лука, Вару и Валу отправились в деревню аборигенов."
                    )
                ))    //Lesson 1 Module 1
            12 -> Lesson(lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "УРОК 2"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))                          //Lesson 2 Module 1
            13 -> Lesson(lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "УРОК 3"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))                          //Lesson 3 Module 1
            14 -> Lesson(isLastLesson = true,lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "УРОК 4"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))      //Lesson 4 Module 1

            21 -> Lesson(isFirstLesson = true, lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 2 УРОК 1"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))    //Lesson 1 Module 2
            22 -> Lesson(lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 2 УРОК 2"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))                          //Lesson 2 Module 2
            23 -> Lesson(isLastLesson = true, lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 2 УРОК 3"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))     //Lesson 3 Module 2

            31 -> Lesson(isFirstLesson = true, lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 3 УРОК 1"
                ),
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Лука открыл глаза и сразу зажмурился: яркое, палящее солнце ослепило его."
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))    //Lesson 1 Module 3
            32 -> Lesson(lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 3 УРОК 2"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))                          //Lesson 2 Module 3
            33 -> Lesson(isLastLesson = true, lessonContent = listOf(
                LessonContent(
                    type = LessonElement.TEXT,
                    text = "Модуль 3 УРОК 3"
                ),
                LessonContent(
                    type = LessonElement.IMAGE,
                    text = R.drawable.img_lesson_c1m1l1_1.toString()
                )
            ))     //Lesson 3 Module 3
            else -> Lesson(lessonContent = emptyList())
        }
    }
}