package com.blannon_network.androidmin_projects.snackBar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MySnackBar(){

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)

        },
        floatingActionButton = {

            FloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                        message = "Always keep it Simple Stupid",
                            actionLabel = "Do it",
                            duration = SnackbarDuration.Indefinite
                    ) }
                }
            ) {
                Text("Hit the Button")
            }

        },

        content = {innerpadding ->
           Text("I Love Mobile Development!",
           Modifier.padding(innerpadding)
               .fillMaxSize()
               .wrapContentSize(),
               fontSize = 20.sp
           )
        }

    )
}