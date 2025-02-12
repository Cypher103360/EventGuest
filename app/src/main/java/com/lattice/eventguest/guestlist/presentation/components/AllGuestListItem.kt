package com.lattice.eventguest.guestlist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lattice.eventguest.ui.theme.EventGuestTheme

@Composable
fun AllGuestListItem(
    name: String,
    surname: String,
    guestClass: String,
    checkInCount: String
) {
    Box {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = .5f))
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp, horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "0 / $checkInCount",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.titleLarge.fontSize
                        )
                    )
                    Text(
                        text = "CHECK-IN",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.titleSmall.fontSize,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(surname)
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(2.dp))
                                .background(
                                    color = if (guestClass == "VIP") {
                                        Color(0xffe99d2a)
                                    } else {
                                        Color.Red
                                    }
                                )
                        ) {
                            Text(
                                text = guestClass,
                                modifier = Modifier.padding(4.dp),
                                style = TextStyle(
                                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            )
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(name)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AllGuestListItemPreview() {
    EventGuestTheme {
        AllGuestListItem(
            name = "Naveen",
            surname = "Singh",
            guestClass = "General",
            checkInCount = "2"
        )
    }
}