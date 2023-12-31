package com.example.ktortutorial.exams

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "title"
const val DETAIL_ARGUMENT_KEY3 = "description"
const val DETAIL_ARGUMENT_KEY4 = "locationname"
const val DETAIL_ARGUMENT_KEY5 = "date"


sealed class Screen(val route: String) {
    object List: Screen(route = "Exam_List")
    object Detail: Screen(route = "Exam_Detail?id={id}") {
fun passId(id: Int = 0): String {
    return "Exam_Detail?id=$id"
}

    }
}
