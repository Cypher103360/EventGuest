package com.lattice.eventguest.guestlist.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lattice.eventguest.guestlist.data.model.Guest
import com.lattice.eventguest.ui.theme.EventGuestTheme

@Composable
fun AllGuestListItem(
    guest: Guest,
    onGuestClick: () -> Unit
) {
    Box(modifier = Modifier
        .clickable {
            onGuestClick()
        }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(guest.name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(guest.email)
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .background(
                            color = Color(0xffe99d2a)
                        )
                ) {
                    Text(
                        text = guest.mobile,
                        modifier = Modifier.padding(4.dp),
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                }

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = if (guest.arrived) {
                        "Arrived"
                    } else {
                        "Not Arrived"
                    },
                    style = TextStyle(
                        color = if (guest.arrived) {
                            Color.Green
                        } else {
                            Color.Red
                        }
                    )
                )
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun AllGuestListItemPreview() {
    EventGuestTheme {
//        AllGuestListItem(
//            name = "Naveen",
//            email = "Singh",
//            number = "General"
//        )
    }
}