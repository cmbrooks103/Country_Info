//Conner Brooks-Chapman
//SER210
//2-13-2025

package edu.quinnipiac.ser210.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.countryinfo.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryListScreen()
        }
    }
}

@Composable
fun CountryListScreen() {
    val countries = listOf(
        Country("India", R.drawable.india, "Indian Rupee", "100 million people come to India's Kumbh Mela Festival", R.drawable.india_map),
        Country("Pakistan", R.drawable.pakistan, "Pakistani Rupee", "Pakistan has a population exceeding 199 million", R.drawable.pakistan_map),
        Country("Sri Lanka", R.drawable.srilanka, "Sri Lankan Rupee", "Sri Lanka is known for its ancient Buddhist ruins", R.drawable.srilanka_map),
        Country("China", R.drawable.china, "Renminbi", "China is the world's most populous country", R.drawable.china_map),
        Country("Afghanistan", R.drawable.afghanistan, "Afghani", "Afghanistan is a landlocked country in South Asia", R.drawable.afghanistan_map),
        Country("North Korea", R.drawable.nkorea, "North Korean Won", "North Korea is officially the DPRK", R.drawable.nkorea_map),
        Country("South Korea", R.drawable.skorea, "South Korean Won", "South Korea is known for its cherry trees and temples", R.drawable.skorea_map),
        Country("Japan", R.drawable.japan, "Japanese Yen", "Japan is famous for its neon skyscrapers and culture", R.drawable.japan_map)
    )

    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(countries) { country ->
            CountryRow(country)
            Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CountryRow(country: Country) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        val flag: Painter = painterResource(id = country.flag)
        Image(painter = flag, contentDescription = "Flag of ${country.name}", modifier = Modifier.size(64.dp))

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = country.name, fontSize = 20.sp, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Currency: ${country.currency}", fontSize = 16.sp)
        }
    }
}

data class Country(
    val name: String,
    val flag: Int,
    val currency: String,
    val fact: String,
    val map: Int
)

@Preview(showBackground = true)
@Composable
fun PreviewCountryListScreen() {
    CountryListScreen()
}
