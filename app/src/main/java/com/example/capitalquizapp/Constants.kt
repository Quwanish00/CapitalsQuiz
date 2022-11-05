package com.example.capitalquizapp

object Constants {
    fun porvideQuestions():List<Question> {
        val questions= mutableListOf<Question>()

        questions.add(
            Question(
                id=0,
                question =R.drawable.uzbekistan ,
                answers =
                    listOf("Rossiya","Uzbekistan","Koreya","Amerika"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id=0,
                question =R.drawable.kazaxstan,
                answers =
                listOf("Kanada","Polsha","Kazaxstan","Indiya"),
                correctAnswerId = 2
            )
        )
        questions.add(
            Question(
                id=0,
                question = R.drawable.rossiya,
                answers =
                listOf("Nigeriya","Qaraqalpagistan","Rossiya","Ispaniya"),
                correctAnswerId = 2
            )
        )
        questions.add(
            Question(
                id=0,
                question = R.drawable.kirgizstan,
                answers =
                listOf("Uzbekistan","Kirgizistan","Avganistan","Yaponiya"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id=0,
                question = R.drawable.kitay,
                answers =
                listOf("Indoneziya","Kitay","Xorvatiya","Shveciya"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id=0,
                question =R.drawable.koreya,
                answers =
                listOf("Shvecariya","Koreya","Chili","Lyuksemburg"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id=0,
                question =R.drawable.amerika,
                answers =
                listOf("Britaniya","Amerika","Vatikan","Palau"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id=0,
                question = R.drawable.avganistan,
                answers =
                listOf("Siriya","Avganistan","Belarusiya","Azerbayjan"),
                correctAnswerId = 1
            )
        )
        questions.add(
            Question(
                id=0,
                question = R.drawable.qaraqalpagstan,
                answers =
                listOf("Qaraqalpagistan","Uzbekistan","Gana","Franciya"),
                correctAnswerId = 0
            )
        )
        questions.add(
            Question(
                id=0,
                question = R.drawable.turkmenistan,
                answers =
                listOf("Turkmenistan","Tadjikistan","Gvineya","Grenlandiya"),
                correctAnswerId = 0
            )
        )


        return questions
    }
}