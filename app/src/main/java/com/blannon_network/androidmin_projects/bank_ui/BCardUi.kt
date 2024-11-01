package com.blannon_network.androidmin_projects.bank_ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BCardUi(){

    val BcardAspectRatio = 1.586f

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp, start = 20.dp, end = 20.dp)
            .aspectRatio(BcardAspectRatio),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
    ){
        Box{
            BCardBackground(baseColor = Color(0xFF1252c8))
        }
    }

}

@Composable
fun BCardBackground(baseColor: Color) {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(baseColor)
    ) { }

}