package com.example.ktortutorial.exams

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController,
        startDestination = Screen.List.route) {
        composable(
            route = Screen.List.route
        ){
            ExamList(navController = navController)
        }
        composable(
            route = "Exam_Detail/{title}/{description}/{locationname}/{date}",
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY2) {
                type = NavType.StringType
            },
                navArgument(DETAIL_ARGUMENT_KEY3){
                    type = NavType.StringType
                },
                navArgument(DETAIL_ARGUMENT_KEY4){
                    type = NavType.StringType
                },
                navArgument(DETAIL_ARGUMENT_KEY5){
                    type = NavType.StringType
                }
            )
        ){backstackEntry ->
            ExamDetail(title = backstackEntry.arguments?.getString("title"),
                description = backstackEntry.arguments?.getString("description"),
                locationname = backstackEntry.arguments?.getString("locationname"),
                date = backstackEntry.arguments?.getString("date"),
                navController = navController)
        }
    }
}