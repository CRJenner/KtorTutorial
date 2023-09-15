package com.example.ktortutorial.repository

import com.example.ktortutorial.api.APIService
import com.example.ktortutorial.model.ExamModel
import com.example.ktortutorial.model.ExamResponse

class ExamRepository (private val service: APIService) {

    suspend fun getCandidateData(): ExamResponse? {
        return service.getCandidateData()
    }
}