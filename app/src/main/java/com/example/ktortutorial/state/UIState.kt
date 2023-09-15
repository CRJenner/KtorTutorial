package com.example.ktortutorial.state

import com.example.ktortutorial.model.ExamModel

data class UIState(
    val currentExamSession: List<ExamModel> = emptyList<ExamModel>().toMutableList()
)
