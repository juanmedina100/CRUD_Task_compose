package com.jimd.misnotaspersonalescompose.navegation

sealed class NavegationManager(val route:String){
    object main:NavegationManager("main")
    object add:NavegationManager("add")
    object updated:NavegationManager("updated/{id}")
}
