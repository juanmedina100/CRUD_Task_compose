package com.jimd.misnotaspersonalescompose.view

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jimd.misnotaspersonalescompose.Utils.MyTopAppBar
import com.jimd.misnotaspersonalescompose.Utils.NotasEvents
import com.jimd.misnotaspersonalescompose.data.local.NotasEntity
import com.jimd.misnotaspersonalescompose.navegation.NavegationManager

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasHome(navController: NavController,viewModel: NotasHomeViewModel) {
    Scaffold(
        topBar = { MyTopAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(NavegationManager.add.route) }) {
                Icon(Icons.Outlined.Add,contentDescription = null)
            }
        }, bottomBar = {
            BottomAppBar {
                Text(text = "BoTTOOOMMMM")
            }
        }
    ) {
        LaunchedEffect(key1 = Unit){
            viewModel.getAllNotasFull()
        }
        val allMyNotas = viewModel.notasInUpdateUI.listaNotas
        Box(modifier= Modifier
            .fillMaxSize()
            .padding(it)){
            LazyColumn{
                items(allMyNotas){
                    Items(lista = it,navController,viewModel)
                }
            }
        }
    }
}

@Composable
fun Items(lista: NotasEntity, navController: NavController, viewModel: NotasHomeViewModel){
    Card(modifier= Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable {
            navController.navigate(NavegationManager.updated.route + "/${Uri.encode(lista.id.toString())}")
        }, elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
        Color.White)) {
        Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(15.dp)) {
                Text(text = lista.titulo,modifier=Modifier.fillMaxWidth(), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = lista.nota,modifier=Modifier.fillMaxWidth(),
                    fontSize = 18.sp, fontWeight = FontWeight.Light,
                    maxLines = 2)
            }
            IconButton(onClick = {
                val aBorrar = NotasEntity(lista.id,lista.titulo,lista.nota)
                viewModel.deleteNota(aBorrar)
            }) {
                Icon(Icons.Outlined.Delete,contentDescription = null)
            }
        }

    }
}