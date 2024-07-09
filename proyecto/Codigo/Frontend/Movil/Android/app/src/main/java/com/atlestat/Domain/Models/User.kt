package com.atlestat.Domain.Models

data class User (
    val nombres:String?=null,
    val apellidos:String?=null,
    val fechaNacimiento:String?=null,
    val correo:String?=null,
    val contrasena:String?=null,
    val dni:String?=null,
    val genero:String?=null,
    val ubicacion:String?=null
)