package com.example.ktortutorial.exams

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(
            route = Screen.List.route
        ){
            ExamList(navController = navController)
        }
        composable(
            route = Screen.Detail.route
        ){
            ExamDetail(navController = navController)
        }
    }
}