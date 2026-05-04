package com.nmp.habittrackeranmp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nmp.habittrackeranmp.R
import com.nmp.habittrackeranmp.databinding.FragmentDashboardBinding
import com.nmp.habittrackeranmp.model.Habit
import com.nmp.habittrackeranmp.view.adapter.HabitListAdapter
import com.nmp.habittrackeranmp.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DashboardViewModel
    private lateinit var habitListAdapter: HabitListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        setupRecyclerView()
        observeViewModel()

        binding.fabAddHabit.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_newHabitFragment)
        }
    }

    private fun setupRecyclerView() {
        habitListAdapter = HabitListAdapter(
            arrayListOf(),
            onPlusClick = { habit: Habit ->
                viewModel.increaseProgress(habit.id)
            },
            onMinusClick = { habit: Habit ->
                viewModel.decreaseProgress(habit.id)
            }
        )

        binding.recHabits.layoutManager = LinearLayoutManager(requireContext())
        binding.recHabits.adapter = habitListAdapter
    }

    private fun observeViewModel() {
        viewModel.habitsLD.observe(viewLifecycleOwner) { habits ->
            habitListAdapter.updateHabitList(habits)

            if (habits.isEmpty()) {
                binding.txtEmptyState.visibility = View.VISIBLE
                binding.recHabits.visibility = View.GONE
            } else {
                binding.txtEmptyState.visibility = View.GONE
                binding.recHabits.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}