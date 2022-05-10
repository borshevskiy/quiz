package com.template

enum class Level(
    val countOfQuestions: Int,
    val countOfRightAnswers: Int,
    val listOfQuestions: List<Question>
) {
    EASY(10, 7, listOf(
            Question.QUESTION_1,
            Question.QUESTION_2,
            Question.QUESTION_3,
            Question.QUESTION_4,
            Question.QUESTION_5,
            Question.QUESTION_6,
            Question.QUESTION_7,
            Question.QUESTION_8,
            Question.QUESTION_9,
            Question.QUESTION_10)
    ),
    MEDIUM(15, 11, listOf(
            Question.QUESTION_1,
            Question.QUESTION_2,
            Question.QUESTION_3,
            Question.QUESTION_4,
            Question.QUESTION_5,
            Question.QUESTION_6,
            Question.QUESTION_7,
            Question.QUESTION_8,
            Question.QUESTION_9,
            Question.QUESTION_10,
            Question.QUESTION_11,
            Question.QUESTION_12,
            Question.QUESTION_13,
            Question.QUESTION_14,
            Question.QUESTION_15)
    ),
    HARD(20, 15, listOf(
        Question.QUESTION_1,
        Question.QUESTION_2,
        Question.QUESTION_3,
        Question.QUESTION_4,
        Question.QUESTION_5,
        Question.QUESTION_6,
        Question.QUESTION_7,
        Question.QUESTION_8,
        Question.QUESTION_9,
        Question.QUESTION_10,
        Question.QUESTION_11,
        Question.QUESTION_12,
        Question.QUESTION_13,
        Question.QUESTION_14,
        Question.QUESTION_15,
        Question.QUESTION_16,
        Question.QUESTION_17,
        Question.QUESTION_18,
        Question.QUESTION_19,
        Question.QUESTION_20)
    )
}