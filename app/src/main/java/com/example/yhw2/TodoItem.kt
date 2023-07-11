package com.example.yhw2

data class TodoItem(
    val id: String,
    val text: String,
    val isDone: Boolean,
    val importance: Importance = Importance.Normal
)

enum class Importance(val text: String) {
    Normal("Нет"),
    High("!! Высокий"),
    Low("Низкий")
}
