package com.atlestat.Domain.Models

data class Team (
    val nombre:String,
    val integrantes:List<User>
)