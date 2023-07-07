package com.example.yhw2

class TodoItemsRepository {

    fun getTasks() = listOf<TodoItem>(
        TodoItem("1", "Первый", false),
        TodoItem("2", "Второй", false),
        TodoItem("3", "Третий", false),
        TodoItem("4", "Четвертый", false),
        TodoItem("5", "Пятый", false),
        TodoItem("6", "Шестой", false),
        TodoItem("7", "Седьмой", false),
        TodoItem("8", "Восьмой", false),
        TodoItem("9", "Девятый", false),
        TodoItem("21", "2Первый", false),
        TodoItem("22", "2Второй", false),
        TodoItem("23", "2Третий", false),
        TodoItem("24", "2Четвертый", false),
        TodoItem("25", "2Пятый", false),
        TodoItem("26", "2Шестой", false),
        TodoItem("27", "2Седьмой", false),
        TodoItem("28", "2Восьмой", false),
        TodoItem("29", "2Девятый", false),
    )
}