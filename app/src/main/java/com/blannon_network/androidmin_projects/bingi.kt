package com.blannon_network.androidmin_projects//package com.blannon_network.testing
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
//import androidx.compose.ui.layout.ContentScale
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
////                    MainScreen()
////                }
////            }
////        }
////    }
////}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Bingi() {
//    var amount by remember { mutableStateOf("") }
//    var cessPoint by remember { mutableStateOf("") }
//    var numberPlate by remember { mutableStateOf("") }
//    var destination by remember { mutableStateOf("") }
//    var item by remember { mutableStateOf("") }
//    var quantity by remember { mutableStateOf("") }
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
//        OutlinedTextField(
//            value = cessPoint,
//            onValueChange = { cessPoint = it },
//            label = { Text("Cess Point") },
//            modifier = Modifier.fillMaxWidth()
//        )
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
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = item,
//            onValueChange = { item = it },
//            label = { Text("Item") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = quantity,
//            onValueChange = { quantity = it },
//            label = { Text("Quantity") },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { showPreview = true },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Print")
//        }
//
//        if (showPreview) {
//            Spacer(modifier = Modifier.height(16.dp))
//            ReceiptPreview(
//                amount = amount.toDoubleOrNull() ?: 0.0,
//                cessPoint = cessPoint,
//                numberPlate = numberPlate,
//                destination = destination,
//                item = item,
//                quantity = quantity.toIntOrNull() ?: 1
//            )
//        }
//    }
//}
//
//@Composable
//fun ReceiptPreview(amount: Double, cessPoint: String, numberPlate: String, destination: String, item: String, quantity: Int) {
//    val receiptNumber = generateRandomNumber(8)
//    val billNumber = "6TL${generateRandomNumber(4)}J"
//    val dsn = "2cc${generateRandomNumber(11)}"
//    val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White)
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Logo placeholder
//        Image(
//            painter = painterResource(id = R.drawable.img_1), // Make sure to add this image to your drawable resources
//            contentDescription = "Kajiado County Logo",
//            modifier = Modifier
//                .size(100.dp)
//                .align(Alignment.CenterHorizontally),
//            contentScale = ContentScale.Fit
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
//        Text("Item: $item")
//        Text("Amount: ${String.format("%.2f", amount)}")
//        Text("Quantity: $quantity")
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
//
