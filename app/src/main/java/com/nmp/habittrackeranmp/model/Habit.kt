package com.nmp.habittrackeranmp.model

data class Habit(
    val id: Int,
    val icon: String,
    val name: String,
    val description: String,
    val unit: String,
    val goal: Int,
    val progress: Int
) {
    val isCompleted: Boolean
        get() = progress >= goal
}