package com.example.ktortutorial.exams

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.ktortutorial.viewmodel.ExamViewModel

@Composable
fun ExamDetail(navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(modifier = Modifier.clickable {
            navController.navigate(route = Screen.List.route)
        },
            text = "title",
            color = Color.Red
        )
    }
}
