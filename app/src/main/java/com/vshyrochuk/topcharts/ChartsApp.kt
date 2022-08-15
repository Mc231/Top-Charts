package com.vshyrochuk.topcharts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vshyrochuk.topcharts.screens.chartpreview.ChartPreviewScreen
import com.vshyrochuk.topcharts.screens.chartslist.ChartsListScreen

@Composable
fun ChartsApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "charts_list",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("charts_list") {
            ChartsListScreen {
                navController.navigate(route = "chart_preview/${it.remoteId}")
            }
        }
        composable(
            "chart_preview/{chartId}",
        ) {
            ChartPreviewScreen(entityId = it.arguments?.getString("chartId"), onBackClicked = {
                navController.popBackStack()
            })
        }
    }
}