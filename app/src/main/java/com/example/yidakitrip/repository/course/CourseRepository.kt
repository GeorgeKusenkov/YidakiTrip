package com.example.yidakitrip.repository.course

import com.example.yidakitrip.model.CourseItemList
import com.example.yidakitrip.model.ModuleItemList

class CourseRepository {
    fun getCourses(): List<CourseItemList> {
        return listOf(
            CourseItemList(
                id = "1",
                title = "Basic course",
                description = "learn about didgeridoo and Really I was searching for this tutorial for a long time, thank you for this gift"
            ),
            CourseItemList(
                id = "2",
                title = "Special course",
                description = "Great content. Thanks. One suggestion :- Please increase the font size of code in your android studio or crop and zoom the video. Please please please. Some viewers (like me) watch your tutorials using phone"
            ),
            CourseItemList(
                id = "3",
                title = "Hard course",
                description = "HOW can we use an items (from our layout resources) and insert them between the sticky headers too ? ( instead of text written from the main activity)"
            ),
            CourseItemList(
                id = "4",
                title = "Simple course",
                description = "This is very helpful. But can you make your tutorials in mvvc way?"
            ),
            CourseItemList(
                id = "5",
                title = "Good course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            )
        )
    }
}