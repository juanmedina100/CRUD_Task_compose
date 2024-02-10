package com.jimd.misnotaspersonalescompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jimd.misnotaspersonalescompose.Utils.MyTopAppBarAdd
import com.jimd.misnotaspersonalescompose.data.local.NotasEntity

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasNews(navController: NavController, viewModel: NotasHomeViewModel= hiltViewModel(), navegationBack:()->Unit) {
    var titulo by rememberSaveable {
        mutableStateOf("")
    }
    var nota by rememberSaveable {
        mutableStateOf("")
    }
    Scaffold(
        topBar = { MyTopAppBarAdd( navegationBack ) }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            Column(modifier= Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                Text(
                    text = "Agregar NOTAS",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp, fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.padding(20.dp))
                OutlinedTextField(value = titulo, onValueChange = { titulo=it }, placeholder = { Text(text = "Titulo")},
                    modifier=Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(value = nota, onValueChange = { nota=it }, placeholder = { Text(text = "Nota")},
                    modifier=Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.padding(30.dp))
                Button(onClick = {
                    val notaNew = NotasEntity(0,titulo,nota)
                    viewModel.insertNotas(notaNew)
                    navController.popBackStack()
                },modifier=Modifier.fillMaxWidth()) {
                    Text(text = "Agregar Nota")
                }
            }
        }
    }
}