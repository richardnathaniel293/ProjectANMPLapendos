package com.nmp.habittrackeranmp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nmp.habittrackeranmp.databinding.FragmentNewHabitBinding
import com.nmp.habittrackeranmp.viewmodel.NewHabitViewModel

class NewHabitFragment : Fragment() {

    private var _binding: FragmentNewHabitBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewHabitViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewHabitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner()

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnCreateHabit.setOnClickListener {
            val name = binding.txtHabitName.text.toString()
            val desc = binding.txtHabitDescription.text.toString()
            val goal = binding.txtGoal.text.toString().toIntOrNull() ?: 0
            val icon = binding.spIcon.selectedItem.toString()

            viewModel.createHabit(name, desc, goal, icon)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.createSuccess.observe(viewLifecycleOwner) {
            if (it == true) {
                Toast.makeText(requireContext(), "Habit berhasil dibuat", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupSpinner() {
        val iconList = arrayOf(
            "Drink Water",
            "Exercise",
            "Read Books",
            "Meditation"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            iconList
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spIcon.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}