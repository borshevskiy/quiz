package com.template

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel(private val level: Level): ViewModel() {

    private val countOfLevelQuestions = level.countOfQuestions
    private val countOfLevelRightAnswers = level.countOfRightAnswers

    private val _question = MutableLiveData<Question>()
    val question: LiveData<Question>
        get() = _question

    private val _gameResult = MutableLiveData<GameResult>()
    val gameResult: LiveData<GameResult>
        get() = _gameResult

    private lateinit var listOfQuestions: List<Question>
    private var rightAnswersCounter = 0
    private var questionCounter = 0

    init {
        startGame()
    }

    private fun startGame() {
        initListOfQuestions()
        generateQuestion()
    }

    fun chooseAnswer(answer: String) {
        checkAnswer(answer)
        updateProgress()
        if (questionCounter < countOfLevelQuestions) generateQuestion() else finishGame()
    }

    private fun updateProgress() {
    }

    private fun checkAnswer(answer: String) {
        val rightAnswer = question.value?.rightAnswer
        if (answer == rightAnswer) {
            rightAnswersCounter++
        }
        questionCounter++
    }

    private fun initListOfQuestions() {
        listOfQuestions = level.listOfQuestions.shuffled()
    }

    private fun generateQuestion() {
        _question.value = listOfQuestions[questionCounter]
    }

    private fun finishGame() {
        _gameResult.value = GameResult(rightAnswersCounter >= countOfLevelRightAnswers, rightAnswersCounter)
    }
}