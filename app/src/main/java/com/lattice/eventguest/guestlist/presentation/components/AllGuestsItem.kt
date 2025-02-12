package com.lattice.eventguest.guestlist.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AllGuestsItem(allText: String) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp), contentAlignment = Alignment.Center) {
        Row(

            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
        ) {
            Text(
                text = allText,
                style = TextStyle(fontSize = MaterialTheme.typography.titleLarge.fontSize, fontWeight = FontWeight.Light)
            )

            Text(
                text = "0/10",
                style = TextStyle(fontSize = MaterialTheme.typography.titleMedium.fontSize, fontWeight = FontWeight.Light)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
        )
    }
}