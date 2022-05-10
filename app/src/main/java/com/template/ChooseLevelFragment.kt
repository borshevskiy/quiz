package com.template

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.template.databinding.FragmentChooseLevelBinding

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLevelEasy.setOnClickListener {
            findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(Level.EASY))
        }
        binding.buttonLevelMedium.setOnClickListener {
            findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(Level.MEDIUM))
        }
        binding.buttonLevelHard.setOnClickListener {
            findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(Level.HARD))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}