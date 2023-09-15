package com.example.ktortutorial.exams

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExamCard(
    title: String,
    navController: NavController
){
    Card(
        modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .wrapContentHeight(),

    ) {
        Row(
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.route)
            },
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(Modifier.padding(20.dp)){
                Text(text = "Exam: $title" ,style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface,)

            }


        }

    }
}