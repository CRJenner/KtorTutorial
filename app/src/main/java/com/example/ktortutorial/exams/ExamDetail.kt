package com.example.ktortutorial.exams

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ktortutorial.viewmodel.ExamViewModel

@Composable
fun ExamDetail(title: String?, description: String?, locationname: String?, navController: NavController
) {
    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
       // LottieAnimation()
        Text(
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
        Text(
            text = "Location: $locationname",
            color = Color.Black,
            fontSize = 24.sp
        )
        Button(onClick = {  navController.navigate(route = Screen.List.route) },
            border = BorderStroke(3.dp, Color.Black),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row{
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null
                )
                Text(text = " return")
            }
        }
        
    }
}
