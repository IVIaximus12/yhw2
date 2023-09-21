package com.example.yhw2

class TodoItemsRepository {

    fun getTasks() = listOf<TodoItem>(
        TodoItem("1", "Первый", false),
        TodoItem(
            "2",
            "Действие игры происходит в 2010 году. Несмотря на трагедию, произошедшую на острове из первой части, эксперименты с «Третьей Энергией» продолжаются в городе Эдвард-Сити. Но, как и в прошлый раз, всё идёт не так, и весь Эдвард-Сити с его окрестностями переносит в прошлое — во времена динозавров.",
            false
        ),
        TodoItem("3", "Третий", true),
        TodoItem("4", "Четвертый", false),
        TodoItem("5", "Пятый", false),
        TodoItem("6", "Шестой", true),
        TodoItem("7", "Седьмой", true),
        TodoItem("8", "Восьмой", false),
        TodoItem("9", "Девятый", false),
        TodoItem("21", "2Первый", false),
        TodoItem("22", "2Второй", false),
        TodoItem("23", "2Третий", true),
        TodoItem("24", "2Четвертый", true),
        TodoItem("25", "2Пятый", false),
        TodoItem("26", "2Шестой", false),
        TodoItem("27", "2Седьмой", false),
        TodoItem("28", "2Восьмой", false),
        TodoItem("29", "2Девятый", false),
    )
}