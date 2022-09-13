package com.easylife.mooddiary.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.easylife.mooddiary.ui.screen.main.MainScreen
import com.easylife.mooddiary.ui.screen.onboarding.OnboardingScreen
import com.easylife.mooddiary.ui.screen.splash.SplashScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            get<SplashScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.Onboarding.route) {
            get<OnboardingScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.Main.route) {
            get<MainScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }


        /*
        composable(route = Screen.Home.route) {
            get<HomeScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(
            route = Screen.Search.route,
            enterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(700))
            },
            exitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.Start, animationSpec = tween(700))
            },
            popEnterTransition = {
                slideIntoContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(700))
            },
            popExitTransition = {
                slideOutOfContainer(AnimatedContentScope.SlideDirection.End, animationSpec = tween(700))
            }
        ) {
            get<SearchScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(
            route = "${Screen.Wallpaper.route}?${WallpaperScreen.WALLPAPER_KEY}={${WallpaperScreen.WALLPAPER_KEY}}",
            arguments = listOf(navArgument(WallpaperScreen.WALLPAPER_KEY) {
                type = WallpaperNavType()
            }),
        ) {
            get<WallpaperScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.About.route) {
            get<AboutScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }

        composable(route = Screen.Collection.route) {
            get<CollectionScreen>().Create(
                viewModel = getViewModel(),
                navController = navController,
                navigationActions = get { parametersOf(navController) }
            )
        }*/
    }
}