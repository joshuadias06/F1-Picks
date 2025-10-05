package com.terminal.f1picks.ui.screens.calendar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.terminal.f1picks.R
import com.terminal.f1picks.ui.theme.DarkPetrolBlue
import com.terminal.f1picks.ui.theme.White

data class Race(
    val countryFlag: Int,
    val trackName: String,
    val trackImage: Int,
    val date: String,
    val time: String,
    val location: String
)

@Composable
fun CalendarScreen(races: List<Race>) {
    var selectedRaceIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPetrolBlue)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Top Card (Flag + Track Name + Arrows)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { if (selectedRaceIndex > 0) selectedRaceIndex-- }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = "Previous Race",
                        tint = White
                    )
                }

                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    border = BorderStroke(1.dp, White.copy(alpha = 0.7f)),
                    modifier = Modifier
                        .weight(1f)
                        .height(60.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                    ) {
                        Image(
                            painter = painterResource(id = races[selectedRaceIndex].countryFlag),
                            contentDescription = "Country Flag",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = races[selectedRaceIndex].trackName,
                            color = White,
                            style = MaterialTheme.typography.titleMedium.copy()
                        )
                    }
                }

                IconButton(
                    onClick = { if (selectedRaceIndex < races.size - 1) selectedRaceIndex++ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardDoubleArrowRight,
                        contentDescription = "Next Race",
                        tint = White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Track Image Card (maior e aproveitando melhor a área)
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                border = BorderStroke(1.dp, White.copy(alpha = 0.7f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp) // altura maior para dar mais destaque
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = races[selectedRaceIndex].trackImage),
                        contentDescription = "Track Image",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .fillMaxHeight(0.85f)
                            .graphicsLayer {
                                rotationZ = 45f
                            },
                        colorFilter = ColorFilter.tint(White)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Race Details
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Date: ${races[selectedRaceIndex].date}",
                    color = White,
                    style = MaterialTheme.typography.bodyLarge.copy()
                )
                Text(
                    text = "Time: ${races[selectedRaceIndex].time}",
                    color = White,
                    style = MaterialTheme.typography.bodyLarge.copy()
                )
                Text(
                    text = "Location: ${races[selectedRaceIndex].location}",
                    color = White,
                    style = MaterialTheme.typography.bodyLarge.copy()
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalendarScreenPreview() {
    val sampleRaces = listOf(
        Race(R.drawable.flag_brazil, "Interlagos", R.drawable.track_brazil, "28 Sep", "15:00", "São Paulo, Brazil"),
        Race(R.drawable.flag_japan, "Suzuka", R.drawable.track_japan, "5 Oct", "08:00", "Suzuka, Japan"),
        Race(R.drawable.flag_uk, "Silverstone", R.drawable.track_uk, "12 Oct", "14:00", "Silverstone, UK")
    )

    CalendarScreen(races = sampleRaces)
}
