package com.nmp.habittrackeranmp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nmp.habittrackeranmp.R
import com.nmp.habittrackeranmp.databinding.ItemHabitBinding
import com.nmp.habittrackeranmp.model.Habit

class HabitListAdapter(
    private val habits: ArrayList<Habit>,
    private val onPlusClick: (Habit) -> Unit,
    private val onMinusClick: (Habit) -> Unit
) : RecyclerView.Adapter<HabitListAdapter.HabitViewHolder>() {

    class HabitViewHolder(val binding: ItemHabitBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val binding = ItemHabitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HabitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = habits[position]
        val context = holder.itemView.context

        holder.binding.imgIcon.setImageResource(getHabitIcon(habit.icon))
        holder.binding.txtHabitName.text = habit.name
        holder.binding.txtHabitDescription.text = habit.description
        holder.binding.txtProgressValue.text = context.getString(
            R.string.habit_progress_detail_format,
            habit.progress,
            habit.goal,
            habit.unit
        )
        holder.binding.progressHabit.max = habit.goal
        holder.binding.progressHabit.progress = habit.progress

        if (habit.isCompleted) {
            holder.binding.txtStatus.text = context.getString(R.string.completed)
            holder.binding.txtStatus.setBackgroundResource(R.drawable.bg_status_completed_chip)
            holder.binding.txtStatus.setTextColor(
                ContextCompat.getColor(context, R.color.status_completed_text)
            )
            holder.binding.cardHabit.strokeColor =
                ContextCompat.getColor(context, R.color.card_completed_stroke)

            holder.binding.viewCompletedIndicator.visibility = View.VISIBLE
            holder.binding.txtCompletedMark.visibility = View.VISIBLE

            holder.binding.progressHabit.progressDrawable =
                ContextCompat.getDrawable(context, R.drawable.progress_completed)
            holder.binding.btnPlus.isEnabled = false
            holder.binding.btnMinus.isEnabled = false
            holder.binding.btnPlus.backgroundTintList =
                ContextCompat.getColorStateList(context, R.color.control_disabled_background)
            holder.binding.btnMinus.backgroundTintList =
                ContextCompat.getColorStateList(context, R.color.control_disabled_background)
            holder.binding.btnPlus.setTextColor(
                ContextCompat.getColor(context, R.color.control_disabled_text)
            )
            holder.binding.btnMinus.setTextColor(
                ContextCompat.getColor(context, R.color.control_disabled_text)
            )
        } else {
            holder.binding.txtStatus.text = context.getString(R.string.in_progress)
            holder.binding.txtStatus.setBackgroundResource(R.drawable.bg_status_in_progress_chip)
            holder.binding.txtStatus.setTextColor(
                ContextCompat.getColor(context, R.color.status_in_progress_text)
            )
            holder.binding.cardHabit.strokeColor =
                ContextCompat.getColor(context, R.color.card_default_stroke)
            holder.binding.viewCompletedIndicator.visibility = View.GONE
            holder.binding.txtCompletedMark.visibility = View.GONE
            holder.binding.progressHabit.progressDrawable =
                ContextCompat.getDrawable(context, R.drawable.progress_in_progress)
            holder.binding.btnPlus.isEnabled = true
            holder.binding.btnMinus.isEnabled = true
            holder.binding.btnPlus.backgroundTintList =
                ContextCompat.getColorStateList(context, R.color.control_plus_background)
            holder.binding.btnMinus.backgroundTintList =
                ContextCompat.getColorStateList(context, R.color.control_minus_background)
            holder.binding.btnPlus.setTextColor(
                ContextCompat.getColor(context, R.color.control_plus_text)
            )
            holder.binding.btnMinus.setTextColor(
                ContextCompat.getColor(context, R.color.control_minus_text)
            )
        }

        holder.binding.btnPlus.setOnClickListener {
            onPlusClick(habit)
        }
        holder.binding.btnMinus.setOnClickListener {
            onMinusClick(habit)
        }
    }

    override fun getItemCount(): Int {
        return habits.size
    }

    fun updateHabitList(newList: List<Habit>) {
        habits.clear()
        habits.addAll(newList)
        notifyDataSetChanged()
    }

    private fun getHabitIcon(icon: String): Int {
        return when (icon) {
            "Drink Water" -> R.drawable.ic_water
            "Exercise" -> R.drawable.ic_fitness
            "Read Books" -> R.drawable.ic_book
            "Meditation" -> R.drawable.ic_meditation
            else -> R.drawable.ic_water
        }
    }
}