package com.atlestat.Presentation.Feed.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.atlestat.Domain.Models.Match
import com.atlestat.Domain.Models.Team
import com.atlestat.Domain.Models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedVM @Inject constructor(

):ViewModel() {
    val teams = mutableStateListOf(
        Team("Alpha", listOf(
            User("Juan", "Perez", "25/03/1990", "juan.perez@example.com", "password123", "12345678", "Male", "Lima"),
            User("Maria", "Gomez", "12/08/1985", "maria.gomez@example.com", "securepass", "87654321", "Female", "Arequipa"),
            User("Carlos", "Gonzalez", "05/11/1992", "carlos.gonzalez@example.com", "qwerty1234", "23456789", "Male", "Cusco"),
            User("Ana", "Lopez", "31/07/1988", "ana.lopez@example.com", "password456", "98765432", "Female", "Trujillo"),
            User("Pedro", "Rodriguez", "18/02/1995", "pedro.rodriguez@example.com", "zxcvbnm", "34567890", "Male", "Chiclayo"),
            User("Sofia", "Ramirez", "29/09/1986", "sofia.ramirez@example.com", "mypassword", "45678901", "Female", "Lima"),
            User("Luis", "Torres", "08/06/1991", "luis.torres@example.com", "strongpass", "56789012", "Male", "Arequipa"),
            User("Isabel", "Flores", "22/12/1989", "isabel.flores@example.com", "pass12345", "67890123", "Female", "Cusco"),
            User("Diego", "Sanchez", "14/04/1994", "diego.sanchez@example.com", "secure123", "78901234", "Male", "Trujillo"),
            User("Valentina", "Diaz", "03/10/1987", "valentina.diaz@example.com", "qwerty", "89012345", "Female", "Chiclayo"),
            User("Javier", "Herrera", "19/03/1980", "javier.herrera@example.com", "admin123", "10111213", "Male", "Lima")
        )),
        Team("Delta", listOf(
            User("Ricardo", "Jimenez", "15/01/1986", "ricardo.jimenez@example.com", "pass12345", "50515253", "Male", "Lima"),
            User("Paola", "Silva", "06/09/1992", "paola.silva@example.com", "password987", "54555657", "Female", "Arequipa"),
            User("Gabriel", "Vargas", "20/05/1990", "gabriel.vargas@example.com", "qwerty123", "58596061", "Male", "Cusco"),
            User("Carmen", "Chavez", "13/03/1989", "carmen.chavez@example.com", "admin1234", "62636465", "Female", "Trujillo"),
            User("Sebastian", "Pacheco", "07/08/1995", "sebastian.pacheco@example.com", "mypassword", "66676869", "Male", "Chiclayo"),
            User("Alejandra", "Leon", "26/02/1984", "alejandra.leon@example.com", "securepass", "70717273", "Female", "Lima"),
            User("Raul", "Mendez", "12/06/1991", "raul.mendez@example.com", "pass12345", "74757677", "Male", "Arequipa"),
            User("Ximena", "Benavides", "03/11/1997", "ximena.benavides@example.com", "password987", "78798081", "Female", "Cusco"),
            User("Eduardo", "Rojas", "21/04/1988", "eduardo.rojas@example.com", "qwerty123", "82838485", "Male", "Trujillo"),
            User("Lucia", "Fuentes", "09/09/1982", "lucia.fuentes@example.com", "admin1234", "86878889", "Female", "Chiclayo"),
            User("Victor", "Huaman", "30/01/1993", "victor.huaman@example.com", "mypassword", "90919293", "Male", "Lima")
        )))
    val pastMatches = mutableStateListOf<Match>(
        Match(
            equipo1 = "Alpha",
            equipo2 = "Delta",
            duracion = "90",
            fecha="28/03/2024",
            equipo1Puntaje = "3",
            equipo2Puntaje = "2"
        )
    )
    val currentMatch= mutableStateListOf<Match>(
        Match(
            equipo1 = "Alpha",
            equipo2 = "Delta",
            duracion = "90",
            fecha="20/03/2024",
            equipo1Puntaje = "0",
            equipo2Puntaje = "1"
        )
    )

    fun AddTeam(team: Team){
        teams.add(team)
    }

    fun AddRecent(match: Match){
        pastMatches.add(0,currentMatch.get(0))
        currentMatch.clear()
        currentMatch.add(match)
    }


}