package com.lattice.eventguest.guestlist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lattice.eventguest.ui.theme.EventGuestTheme

@Composable
fun DemoEventItem(title: String, date: String, onEventClick: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onEventClick()
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Light
                )
            )
            Spacer(modifier = Modifier.padding(6.dp))
            Text(
                text = date,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Row {
                Row {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "guests",
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "10 guests",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize
                        )
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "guests",
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "Madison Square Garden",
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize
                        )
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EventGuestTheme {
        DemoEventItem(
            title = "A demo event",
            date = "19 Feb 2025 01:30",
            onEventClick = {}
        )
    }
}