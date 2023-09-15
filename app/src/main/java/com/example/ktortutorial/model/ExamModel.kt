package com.example.ktortutorial.model

import kotlinx.serialization.Serializable

@Serializable
data class ExamResponse(
    val candidateData: List<ExamModel>
)

@Serializable
data class ExamModel(
    val id: Int,
    val title: String,
    val description:String,
    val candidateid: Int,
    val candidatename: String,
    val date: String,
    val locationname: String,
    val latitude: String,
    val longitude:String
)
