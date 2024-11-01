package com.blannon_network.androidmin_projects
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import java.text.SimpleDateFormat
//import java.util.*
//import kotlin.random.Random
//
////class MainActivity : ComponentActivity() {
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        setContent {
////            MaterialTheme {
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colorScheme.background
////                ) {
////                    MyMainScreen()
////                }
////            }
////        }
////    }
////}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyMainScreen() {
//    var amount by remember { mutableStateOf("") }
//    var selectedCessPoint by remember { mutableStateOf("") }
//    var numberPlate by remember { mutableStateOf("") }
//    var destination by remember { mutableStateOf("") }
//    var showPreview by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState())
//    ) {
//        OutlinedTextField(
//            value = amount,
//            onValueChange = { amount = it },
//            label = { Text("Amount") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        // Dropdown for Cess Point
//        var expanded by remember { mutableStateOf(false) }
//        val cessPoints = listOf("EMALI ROADBLOCK", "OTHER CESS POINT 1", "OTHER CESS POINT 2")
//
//        ExposedDropdownMenuBox(
//            expanded = expanded,
//            onExpandedChange = { expanded = !expanded }
//        ) {
//            OutlinedTextField(
//                value = selectedCessPoint,
//                onValueChange = {},
//                readOnly = true,
//                label = { Text("Cess Point") },
//                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
//                modifier = Modifier.fillMaxWidth()
//            )
//            ExposedDropdownMenu(
//                expanded = expanded,
//                onDismissRequest = { expanded = false }
//            ) {
//                cessPoints.forEach { point ->
//                    DropdownMenuItem(
//                        text = { Text(point) },
//                        onClick = {
//                            selectedCessPoint = point
//                            expanded = false
//                        }
//                    )
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = numberPlate,
//            onValueChange = { numberPlate = it },
//            label = { Text("Number Plate") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = destination,
//            onValueChange = { destination = it },
//            label = { Text("Destination") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { showPreview = true },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Preview Receipt")
//        }
//
//        if (showPreview) {
//            Spacer(modifier = Modifier.height(16.dp))
//            ReceiptPreview(
//                amount = amount.toDoubleOrNull() ?: 0.0,
//                cessPoint = selectedCessPoint,
//                numberPlate = numberPlate,
//                destination = destination
//            )
//        }
//    }
//}
//
//@Composable
//fun ReceiptPreview(amount: Double, cessPoint: String, numberPlate: String, destination: String) {
//    val receiptNumber = generateRandomNumber(8)
//    val billNumber = "6TL${generateRandomNumber(4)}J"
//    val dsn = "2cc${generateRandomNumber(11)}"
//    val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White)
//            .padding(16.dp)
//    ) {
//        // Logo placeholder
//        Image(
//            painter = painterResource(id = R.drawable.img_1), // Make sure to add this image to your drawable resources
//            contentDescription = "Kajiado County Logo",
//            modifier = Modifier
//                .size(100.dp)
//                .align(Alignment.CenterHorizontally)
//        )
//
//        Text("County Government \n of Kajiado", fontWeight = FontWeight.Bold, fontSize = 18.sp)
//        Text("*** V1 ***", fontWeight = FontWeight.Bold)
//        Text("Receipt No: $receiptNumber")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("Amount: ${String.format("%.1f", amount)}")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("Cess Point: $cessPoint")
//        Text("Number Plate: $numberPlate")
//        Text("Destination: $destination")
//        Text("Bill No: $billNumber")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("Item: Ballast")
//        Text("Amount: ${String.format("%.2f", amount)}")
//        Text("Quantity: 1")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("Issued by: David Mpessi")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text("DSN: $dsn")
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(date)
//        Text("KajiadoPay")
//    }
//}
//
//fun generateRandomNumber(length: Int): String {
//    return buildString {
//        repeat(length) {
//            append(Random.nextInt(10))
//        }
//    }
//}