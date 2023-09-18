package com.example.ktortutorial.exams

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String) {
    object List: Screen(route = "Exam_List")
    object Detail: Screen(route = "Exam_Detail?id={id}&name={name}") {
//fun passId(id: Int = 0): String {
//    return "Exam_Detail?id=$id"
//}
        fun passNameAndId(
id: Int = 0,
name: String = "Bob"
        ): String {
            return "Exam_Detail?id=$id&name=$name"
        }
    }
}
