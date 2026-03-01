package com.example.countriesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.countriesapp.domain.model.Country

@Composable
fun CountryCard(
    country: Country,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(country.code) },
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            AsyncImage(
                model = country.flagUrl,
                contentDescription = "Bandera de ${country.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(bottom = 10.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = country.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "Capital: ${country.capital}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "Región: ${country.region}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}