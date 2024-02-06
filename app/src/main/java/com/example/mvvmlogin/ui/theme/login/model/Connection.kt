package com.example.mvvmlogin.ui.theme.login.model

import khttp.get
import khttp.post
class Connection {

    val response = get("https://jsonplaceholder.typicode.com/todos/1")

    companion object{

        //Instancia
        private var ConectInstance: Connection? = null


        fun getInstance(): Connection?{
            if(ConectInstance == null){
                ConectInstance = Connection()
            }

            return ConectInstance
        }

    }





}