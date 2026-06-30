package com.nmp.habittrackeranmp.view

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.nmp.habittrackeranmp.R
import com.nmp.habittrackeranmp.model.Habit

@BindingAdapter("habitIcon")
fun setHabitIcon(view: ImageView, icon: String?) {
    val resId = when (icon) {
        "Drink Water" -> R.drawable.ic_water
        "Exercise" -> R.drawable.ic_fitness
        "Read Books" -> R.drawable.ic_book
        "Meditation" -> R.drawable.ic_meditation
        else -> R.drawable.ic_water
    }
    view.setImageResource(resId)
}

@BindingAdapter("progressDetail")
fun setProgressDetail(view: TextView, habit: Habit) {
    view.text = view.context.getString(
        R.string.habit_progress_detail_format,
        habit.progress,
        habit.goal,
        habit.unit
    )
}