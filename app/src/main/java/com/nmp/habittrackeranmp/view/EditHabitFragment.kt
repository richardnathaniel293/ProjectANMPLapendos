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
import androidx.navigation.fragment.navArgs
import com.nmp.habittrackeranmp.databinding.FragmentEditHabitBinding
import com.nmp.habittrackeranmp.viewmodel.EditHabitViewModel

class EditHabitFragment : Fragment() {

    private var _binding: FragmentEditHabitBinding? = null
    private val binding get() = _binding!!

    private val args: EditHabitFragmentArgs by navArgs()
    private val viewModel: EditHabitViewModel by viewModels()

    private val iconList = arrayOf(
        "Drink Water",
        "Exercise",
        "Read Books",
        "Meditation"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditHabitBinding.inflate(inflater, container, false)
        // viewModel & lifecycleOwner wajib di-set agar two way binding (@={...})
        // pada layout dapat berjalan dan otomatis update saat data berubah
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSpinner()

        viewModel.loadHabit(args.habitId)

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSubmit.setOnClickListener {
            val selectedIcon = binding.spIcon.selectedItem?.toString().orEmpty()
            viewModel.updateHabit(selectedIcon)
        }

        observeViewModel()
    }

    private fun setupSpinner() {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            iconList
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spIcon.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.habitLoaded.observe(viewLifecycleOwner) { habit ->
            val position = iconList.indexOf(habit.icon)
            if (position >= 0) {
                binding.spIcon.setSelection(position)
            }
        }

        viewModel.updateSuccess.observe(viewLifecycleOwner) {
            if (it == true) {
                Toast.makeText(requireContext(), "Habit berhasil diperbarui", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            if (it != null) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}