package com.jimd.misnotaspersonalescompose.Utils

sealed class MyResource<T>(val data:T?=null,val message:String?=null){
    class Success<T>(data: T?):MyResource<T>(data = data)
    class Failure<T>(message: String?):MyResource<T>(message = message)
}
