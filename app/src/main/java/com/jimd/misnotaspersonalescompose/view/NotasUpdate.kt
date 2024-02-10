package com.jimd.misnotaspersonalescompose.view

import android.annotation.SuppressLint
import android.net.Uri
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jimd.misnotaspersonalescompose.Utils.MyTopAppBarUpdate
import com.jimd.misnotaspersonalescompose.Utils.NotasEvents
import com.jimd.misnotaspersonalescompose.data.local.NotasEntity

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasUpdate(navegationControler: NavHostController, viewModel: NotasHomeViewModel= hiltViewModel(), id:String, navegationBack:()->Unit) {
    val uriId = Uri.decode(id)
    LaunchedEffect(key1 = Unit){
        viewModel.getNotasForId(uriId.toString().toInt())
        viewModel.onEventUpdate(NotasEvents.idViene(uriId.toInt()))
    }
    val notaUpdated = viewModel.notasInUpdateUI
    Scaffold(
        topBar = { MyTopAppBarUpdate (navegationBack) }
    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "NOTAS update $uriId",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp, fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.padding(20.dp))
            OutlinedTextField(value = notaUpdated.titulo,
                onValueChange = { viewModel.onEventUpdate(NotasEvents.tituloChanged(it)) },
                placeholder = { Text(text = "Titulo") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(value = notaUpdated.nota,
                onValueChange = { viewModel.onEventUpdate(NotasEvents.notasChanged(it)) },
                placeholder = { Text(text = "Nota") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(30.dp))
            Button(onClick = {
                viewModel.onEventUpdate(NotasEvents.updateNota)
                navegationControler.popBackStack()
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "UPDATE")
            }
        }
    }
}
}