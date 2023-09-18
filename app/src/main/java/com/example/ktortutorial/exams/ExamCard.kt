package com.example.ktortutorial.exams

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ExamCard(
    id: Int,
    title: String,
    description: String,
    locationname: String,
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
                navController.navigate(
                   // route = Screen.Detail.passId(id)
                    route = "Exam_Detail/$title/$description/$locationname"
                )
            },
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(Modifier.padding(20.dp))
            {
                Text(text = "Exam: ${title}" ,style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface,)
                Spacer(Modifier.weight(1f).fillMaxHeight())
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )

            }


        }

    }
}