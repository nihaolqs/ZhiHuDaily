package com.lqs.zhihudaily.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lqs.zhihudaily.theme.ZhiHuDailyTheme

/**
 * @Description:     java类作用描述
 * @Author:         Linqs
 * @CreateDate:     2021/10/11 15:09
 * @UpdateUser:     更新者：
 * @UpdateDate:     2021/10/11 15:09
 * @UpdateRemark:   更新说明：
 */

@Composable
fun DailyApp() {
    ZhiHuDailyTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_ROUTE
        DailyNavGraph(navController)
    }
}