package com.example.ktortutorial.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktortutorial.api.APIService
import com.example.ktortutorial.model.ExamModel
import com.example.ktortutorial.repository.ExamRepository
import com.example.ktortutorial.state.UIState

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private val _uiState = MutableStateFlow(UIState())
val uiState = _uiState

class ExamViewModel: ViewModel() {
    private val repository: ExamRepository = ExamRepository(service = APIService.create())


    fun getCandidateData() {
        viewModelScope.launch(Dispatchers.IO) {
            val examResponse = repository.getCandidateData()
            print("EXAM RESPONSE" + examResponse)
            if (examResponse != null) {
                println("its here so far")
                uiState.value = UIState(currentExamSession = examResponse.candidateData)
            } else {
                println("EXAM RESPONSE is null")
            }
        }
    }
}

//    fun updateExamList(exams: List<ExamModel>) {
//        uiState.update { state ->
//            state.copy(currentExamSession = exams)
//        }
//
//    }
