package com.inslab.planets


import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class TitleSc(val title: String) {
    Start(title = R.string.app_name.toString()),
    Ourgalaxy(title = "Our galaxy"),
    OtherGalexies(title = "Other galaxies"),
//    Summary(title = R.string.order_summary)
}
@Composable
fun HomeScreen(
    currentScreen: TitleSc,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,) {
    TopAppBar(
        title = { Text((currentScreen.title)) },
        modifier = Modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back button"
                    )
                }
            }
        }
    )
}
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
//    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)
{

    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = TitleSc.valueOf(
        backStackEntry?.destination?.route ?: TitleSc.Start.name
    )
    NavHost(
        navController = navController,
        startDestination = TitleSc.Start.name,
    ) {
        composable(route = TitleSc.Start.name) {
            HomeScreen(
                onNextButtonClicked = {
                    navController.navigate(TitleSc.Ourgalaxy.name)
                }, onPrevButtonClicked = {
                    navController.navigate(TitleSc.OtherGalexies.name)
                }
            )
        }
        composable(route = TitleSc.Ourgalaxy.name) {
            val context = LocalContext.current
            showPlanets(
            )
        }
        composable(route = TitleSc.OtherGalexies.name) {
            val context = LocalContext.current
            othergalaxies(
            )
        }
    }
}