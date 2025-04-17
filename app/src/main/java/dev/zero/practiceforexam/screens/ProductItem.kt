package dev.zero.practiceforexam.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.zero.practiceforexam.model.Product

@Composable
fun ProductItem(product: Product, onClick:() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
       Row(modifier = Modifier.padding(8.dp)) {
           AsyncImage(
               model = product.image,
               contentDescription = product.name,
               modifier = Modifier.size(64.dp)
           )
           Spacer(modifier = Modifier.width(16.dp))
           Column{
               Text(text = product.name)
               Text(text = "${product.price} VND")
           }
       }
    }
}

