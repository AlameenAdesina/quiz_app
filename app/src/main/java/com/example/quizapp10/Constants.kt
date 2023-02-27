package com.example.quizapp10

object Constants {

    const val USER_NAME: String = "user_name"
    const val  TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.nigeria_flag,
            "Nigeria","South Sudan","Ghana", "Cameroon",
            1

        )
        questionList.add(que1)

        val que2 = Question(
            2,"What country does this flag belong to?",
            R.drawable.dr_congo_flag,
            "Algeria","Angola","Dr Congo", "Cameroon",
            3

        )
        questionList.add(que2)

        val que3 = Question(
            3,"What country does this flag belong to?",
            R.drawable.egypt_flag,
            "Burkina Faso","South Sudan","Dijibouti", "Egypt",
            4

        )
        questionList.add(que3)

        val que4 = Question(
            1,"What country does this flag belong to?",
            R.drawable.ethiopia_flag,
            "Cameroon","Niger","Ethiopia", "South Sudan",
            3

        )
        questionList.add(que4)

        val que5 = Question(
            5,"What country does this flag belong to?",
            R.drawable.ghanian_flag,
            "Ghana","Liberia","Burundi", "Tanzania",
            1

        )
        questionList.add(que5)

        val que6 = Question(
            6,"What country does this flag belong to?",
            R.drawable.kenyan_flag,
            "Cameroon","Kenya","Ethiopia", "South Africa",
            2

        )
        questionList.add(que6)

        val que7 = Question(
            7,"What country does this flag belong to?",
            R.drawable.morocco_flag,
            "Morocco","Eritrea","South Africa", "South Sudan",
            1

        )
        questionList.add(que7)

        val que8 = Question(
            8,"What country does this flag belong to?",
            R.drawable.south_africa_flag,
            "Togo","South Africa","Sierra Leone", "Uganda",
            2

        )
        questionList.add(que8)

        val que9 = Question(
            9,"What country does this flag belong to?",
            R.drawable.south_sudan_flag,
            "Zimbabwe","Sierra Leone", "Mali", "South Sudan",
            4

        )
        questionList.add(que9)

        val que10 = Question(
            10,"What country does this flag belong to?",
            R.drawable.uganda_flag,
            "Gabon","Uganda", "Malawi", "Côte d'Ivoire",
            2

        )
        questionList.add(que10)




        return questionList

    }
}