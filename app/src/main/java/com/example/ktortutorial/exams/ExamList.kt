package com.example.ktortutorial.exams

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.ktortutorial.model.ExamModel
import com.example.ktortutorial.viewmodel.ExamViewModel
import com.example.ktortutorial.state.UIState
import com.example.ktortutorial.viewmodel.uiState
import kotlinx.coroutines.flow.collectLatest


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamList(
    navController: NavController,
    modifier: Modifier = Modifier,
    examViewModel: ExamViewModel = ExamViewModel()) {
    val collectedUiState: State<UIState> = uiState.collectAsState()

    LaunchedEffect(Unit) {
        examViewModel.getCandidateData()
    }
    println("Exam List Size: ${collectedUiState.value.currentExamSession.size}")

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
            ) {
                Text(text = "VICTVS", style = MaterialTheme.typography.headlineLarge, color = Color.White)
                Text("ExamList", style = MaterialTheme.typography.headlineMedium, color = Color.White)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp)
            ) {
                collectedUiState.value.currentExamSession.forEach { exam ->
                    item {
                        ExamCard( exam.title, navController)
                }
                }
            }
        }
    }
}



