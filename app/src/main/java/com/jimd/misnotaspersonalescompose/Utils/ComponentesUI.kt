package com.jimd.misnotaspersonalescompose.Utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun MyTopAppBar(){
    TopAppBar(title = { Text(text = "Notas Main",modifier= Modifier.fillMaxWidth(),
        color = Color.Black, textAlign = TextAlign.Center) },modifier=Modifier.fillMaxWidth())
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarAdd(MynavigationBack:()->Unit){
    TopAppBar(title = { Text(text = "Agregar notas",modifier= Modifier.fillMaxWidth(),
        color = Color.Black) },modifier=Modifier.fillMaxWidth(),
        navigationIcon = { IconButton(onClick =  MynavigationBack  ) {
            Icon(imageVector = Icons.Outlined.ArrowBack,contentDescription = null)
        } })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarUpdate(MynavigationBack:()->Unit){
    TopAppBar(title = { Text(text = "Update notas",modifier= Modifier.fillMaxWidth(),
        color = Color.Black) },modifier=Modifier.fillMaxWidth(),
        navigationIcon = { IconButton(onClick =  MynavigationBack  ) {
            Icon(imageVector = Icons.Outlined.ArrowBack,contentDescription = null)
        } })
}

@Composable
fun AlertaNotasNew(){

}