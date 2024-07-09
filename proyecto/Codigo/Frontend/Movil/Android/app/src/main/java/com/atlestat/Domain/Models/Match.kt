package com.atlestat.Domain.Models

data class Match (
    val equipo1:String,
    val equipo2:String,
    val duracion:String,
    val fecha:String,
    val equipo1Puntaje:String?=null,
    val equipo2Puntaje: String?=null
)