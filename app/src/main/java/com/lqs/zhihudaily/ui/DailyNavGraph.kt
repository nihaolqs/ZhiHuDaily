package com.lqs.zhihudaily.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/11 15:24
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/11 15:24
 * @UpdateRemark:   更新说明：
 */

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val DETAILY_ROUTE = "detaily"
}

@Composable
fun DailyNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            HomeScreen({ id -> navController.navigate("${MainDestinations.DETAILY_ROUTE}/${id}") })
        }

        composable(
            "${MainDestinations.DETAILY_ROUTE}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            val detailyViewModel: DetailyViewModel = viewModel()
            detailyViewModel.getStoryDetaily(id ?: "")
            DetailyScreen(detailyViewModel.detailyBean.observeAsState())
        }
    }
}