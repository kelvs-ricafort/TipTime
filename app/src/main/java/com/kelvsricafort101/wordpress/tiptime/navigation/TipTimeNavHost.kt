package com.kelvsricafort101.wordpress.tiptime.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kelvsricafort101.wordpress.tiptime.data.AppLanguage
import com.kelvsricafort101.wordpress.tiptime.ui.screens.AboutAppDestination
import com.kelvsricafort101.wordpress.tiptime.ui.screens.AboutAppScreen
import com.kelvsricafort101.wordpress.tiptime.ui.screens.HomeDestination
import com.kelvsricafort101.wordpress.tiptime.ui.screens.HomeScreen
import com.kelvsricafort101.wordpress.tiptime.ui.screens.SettingsDestination
import com.kelvsricafort101.wordpress.tiptime.ui.screens.SettingsScreen
import com.kelvsricafort101.wordpress.tiptime.ui.screens.SettingsUiState

/**
 * Provides Navigation Graph for the application.
 */
@Composable
fun TipTimeNavHost(
    navController: NavHostController,
    settingsUiState: SettingsUiState,
    onDarkModeChanged: (Boolean) -> Unit,
    onLanguageSelected: (AppLanguage) -> Unit,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TipTimeNavigationDrawer(
        selectedRoute = currentRoute,
        onNavigate = { route ->
            navController.navigate(route) {
                popUpTo(HomeDestination.route) {
                    saveState = true
                }

                launchSingleTop = true
                restoreState = true
            }
        }
    ) { openDrawer ->
        NavHost(
            navController = navController,
            startDestination = HomeDestination.route,
            modifier = modifier
        ) {
            composable(route = HomeDestination.route) {
                HomeScreen(
                    openDrawer = openDrawer,
                    modifier = modifier
                )
            }
            // About Screen
            composable(route = AboutAppDestination.route) {
                AboutAppScreen(
                    onNavigateUp = {
                        navController.navigateUp()
                    }
                )
            }
            // Settings Screen
            composable(route = SettingsDestination.route) {
                SettingsScreen(
                    onNavigateUp = {
                        navController.navigateUp()
                    },
                    darkMode = settingsUiState.darkMode,
                    onDarkModeChanged = onDarkModeChanged,
                    selectedLanguage = AppLanguage.ENGLISH,
                    onLanguageSelected = onLanguageSelected
                )
            }
        }
    }
}