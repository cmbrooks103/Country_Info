//Conner Brooks-Chapman
//SER210
//2-13-2025
package edu.quinnipiac.ser210.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.quinnipiac.ser210.countryinfo.CountryScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryNavigation()
        }
    }
}

@Composable
fun CountryNavigation() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            CountryAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = CountryScreens.HomeScreen.name, modifier = Modifier.padding(innerPadding)) {

            composable(CountryScreens.HomeScreen.name) {
                CountryListScreen(navController)
            }

            composable(
                route = CountryScreens.DetailScreen.name + "/{countryName}",
                arguments = listOf(navArgument("countryName") { type = NavType.StringType })
            ) { backStackEntry ->
                val countryName = backStackEntry.arguments?.getString("countryName") ?: ""
                CountryDetailScreen(navController, countryName)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCountryNavigation() {
    CountryNavigation()
}
