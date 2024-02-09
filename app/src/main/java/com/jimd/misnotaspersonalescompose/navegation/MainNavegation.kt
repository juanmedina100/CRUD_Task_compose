package com.jimd.misnotaspersonalescompose.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.jimd.misnotaspersonalescompose.view.NotasHome
import com.jimd.misnotaspersonalescompose.view.NotasNews
import com.jimd.misnotaspersonalescompose.view.NotasUpdate

@Composable
fun mainNavegation(navController: NavHostController){
//    NavHost(navController = navController, startDestination = NavegationManager.main.route){
//        composable(NavegationManager.main.route){ NotasHome(navController) }
//        composable(NavegationManager.add.route){ NotasNews(
//            navController = navController,
//            viewModel = viewModel, navegationBack = { navController.popBackStack() }
//        ) }
//        composable(NavegationManager.updated.route+"/{id}",
//            arguments = listOf(
//                navArgument("id"){ type = NavType.StringType }
//            )){ navbackStack->
//            NotasUpdate(
//                navegationControler =  navController,
//                viewModel =  viewModel,
//                id = navbackStack.arguments?.getString("id").orEmpty(),
//                navegationBack = { navController.popBackStack() }
//            ) }
//    }
}