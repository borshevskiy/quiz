package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.template.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<GameFragmentArgs>()

    private val viewModelFactory by lazy { GameViewModelFactory(args.level) }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[GameViewModel::class.java]
    }

    private val answersTextViews by lazy { mutableListOf<TextView>().apply {
        with(binding) {
                add(answer1)
                add(answer2)
                add(answer3)
                add(answer4)
            }
        }
    }

    private lateinit var rightAnswer: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        setClickListenersToOptions()
    }

    private fun setClickListenersToOptions() {
        for (answers in answersTextViews) {
            answers.setOnClickListener {
                val answer = answers.text.toString()
                viewModel.chooseAnswer(answer)
                showNotification(answer)
            }
        }
    }

    private fun showNotification(answer: String) {
        if (answer == rightAnswer) {
            binding.correctAnswer.visibility = View.VISIBLE
            binding.wrongAnswer.visibility = View.INVISIBLE
        } else {
            binding.wrongAnswer.visibility = View.VISIBLE
            binding.correctAnswer.visibility = View.INVISIBLE
            binding.wrongTextView.text = String.format(getString(R.string.wrong_notification), rightAnswer)
        }
    }

    private fun observeViewModel() {
        with(binding) {
            viewModel.question.observe(viewLifecycleOwner) {
                rightAnswer = it.rightAnswer
                question.text = it.question
                val shuffledAnswers = it.listOfAnswers.shuffled()
                for (i in 0 until answersTextViews.size) {
                    answersTextViews[i].text = shuffledAnswers[i]
                }
            }
            viewModel.gameResult.observe(viewLifecycleOwner) {
                findNavController().navigate(
                    GameFragmentDirections.actionGameFragmentToFinishFragment(it, args.level)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}