package com.example.ktortutorial.exams

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ktortutorial.viewmodel.ExamViewModel

@Composable
fun ExamDetail(title: String?, description: String?, navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
       // LottieAnimation()
        Text(modifier = Modifier.clickable {
            navController.navigate(route = Screen.List.route)
        },
            text = "Exam: $title",
            color = Color.Black,
            fontSize = 34.sp,

        )
        Spacer(modifier = Modifier)
        Text(
            text = "Description: $description",
            color = Color.Black,
            fontSize = 24.sp

        )
    }
}
