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
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                type = NavType.IntType
                    defaultValue = 0
            },
                navArgument(DETAIL_ARGUMENT_KEY2){
                    type = NavType.StringType
                }
            )
        ){
            Log.d("Args", it.arguments?.getInt(DETAIL_ARGUMENT_KEY).toString())
            Log.d("Args", it.arguments?.getString(DETAIL_ARGUMENT_KEY2).toString())

            ExamDetail(navController = navController)
        }
    }
}