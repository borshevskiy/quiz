package com.template

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.template.databinding.FragmentFinishBinding

class FinishFragment : Fragment() {

    private val args by navArgs<FinishFragmentArgs>()
    private var _binding: FragmentFinishBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    private fun bindViews() {
        with(binding) {
            playAgainButton.setOnClickListener {
                findNavController().popBackStack()
            }
            mainMenuButton.setOnClickListener {
                findNavController().navigate(R.id.action_finishFragment_to_startFragment)
            }
            resultImage.setImageResource(showSmile())
            scoreAnswers.text = String.format(getString(R.string.count_of_answers),
                args.gameResult.countOfRightAnswers,
                args.level.countOfQuestions - args.gameResult.countOfRightAnswers)
        }
    }

    private fun showSmile() = if (args.gameResult.isWin) R.drawable.ic_win else R.drawable.ic_lose

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}