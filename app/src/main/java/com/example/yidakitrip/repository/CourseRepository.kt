package com.example.yidakitrip.repository

import com.example.yidakitrip.model.Course

class CourseRepository {
    fun getAllData(): List<Course> {
        return listOf(
            Course(
                id = "1",
                title = "Basic course",
                description = "learn about didgeridoo and Really I was searching for this tutorial for a long time, thank you for this gift"
            ),
            Course(
                id = "2",
                title = "Special course",
                description = "Great content. Thanks. One suggestion :- Please increase the font size of code in your android studio or crop and zoom the video. Please please please. Some viewers (like me) watch your tutorials using phone"
            ),
            Course(
                id = "1",
                title = "Hard course",
                description = "HOW can we use an items (from our layout resources) and insert them between the sticky headers too ? ( instead of text written from the main activity)"
            ),
            Course(
                id = "1",
                title = "Simple course",
                description = "This is very helpful. But can you make your tutorials in mvvc way?"
            ),
            Course(
                id = "2",
                title = "Good course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            ),
            Course(
                id = "2",
                title = "Not Bad course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            ),
            Course(
                id = "1",
                title = "Graet course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            ),
            Course(
                id = "2",
                title = "Nice course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            ),
            Course(
                id = "1",
                title = "Realy course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            ),
            Course(
                id = "2",
                title = "Pro course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            ),
            Course(
                id = "2",
                title = "Basic Pro course",
                description = "Great vídeo as always! Please put subtitles in next videos, thanks"
            )
        )
    }
}