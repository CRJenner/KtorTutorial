package com.example.ktortutorial.exams

sealed class Screen(val route: String) {
    object List: Screen(route = "Exam_List")
    object Detail: Screen(route = "Exam_Detail")
}
