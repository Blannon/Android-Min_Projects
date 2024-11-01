package com.blannon_network.androidmin_projects.bank_ui

import androidx.compose.ui.graphics.Color
import kotlin.math.min

fun Color.toHsl(): FloatArray{

    val redComponent = red
    val greenComponent = green
    val blueComponent = blue

    val maxComponent = maxOf(redComponent, greenComponent, blueComponent)

    val minComponent = minOf(redComponent, greenComponent, blueComponent)

    val delta = maxComponent- minComponent

    val lightness =(maxComponent + minComponent) / 2

    val hue: Float
    val saturation: Float

    if (maxComponent == minComponent){

        hue = 0f
        saturation = 0f
    }  else{
        saturation = if (
            lightness > 0.5
        )
            delta / (2 - maxComponent - minComponent) else delta / (maxComponent + minComponent)

        hue = when (maxComponent){
            redComponent -> 60 * ((greenComponent - blueComponent) / delta % 6)
            greenComponent -> 60 * ((blueComponent - redComponent) / delta + 2)

            else -> 60 * ((redComponent - greenComponent) / delta + 4)
        }
    }

    return  floatArrayOf(hue.coerceIn(0f, 360f), saturation, lightness)
}

fun hslToColor(hue: Float, saturation: Float, lightness: Float): Color{

    val chroma = (1 - kotlin.math.abs(2 * lightness - 1)) * saturation

    val secondaryColorComponent = chroma * (1 - kotlin.math.abs((hue / 60) % 2 - 1))

    val matchValue = lightness - chroma / 2

    var red = matchValue
    var green = matchValue
    var blue = matchValue

    when ((hue.toInt() / 60) % 6){

        0 -> {red += chroma; green += secondaryColorComponent}

        1 -> {red += secondaryColorComponent; green += chroma}

        2 -> {green += chroma; blue += secondaryColorComponent}

        3 -> {green += secondaryColorComponent; blue += chroma}

        4 -> {red += secondaryColorComponent; blue += chroma}

        5 -> {red += chroma; blue += secondaryColorComponent}
    }

    return  Color(red = red, green = green, blue = blue)
}

fun Color.setSaturation(newSaturation: Float): Color {
    val hsValues = this.toHsl()

    return hslToColor(hsValues[0], newSaturation.coerceIn(0f, 1f), hsValues[2])
}