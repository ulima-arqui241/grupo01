package com.atlestat.Presentation.Login.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.atlestat.Domain.Models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor():ViewModel() {
    val loggedUser= mutableStateOf(User())
    val users = mutableStateListOf(
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
        User("Javier", "Herrera", "19/03/1980", "javier.herrera@example.com", "admin123", "10111213", "Male", "Lima"),
        User("Luciana", "Castillo", "27/05/1993", "luciana.castillo@example.com", "password567", "14151617", "Female", "Arequipa"),
        User("Miguel", "Mendoza", "01/09/1989", "miguel.mendoza@example.com", "mypass123", "18192021", "Male", "Cusco"),
        User("Gabriela", "Alvarado", "16/04/1996", "gabriela.alvarado@example.com", "secretpass", "22232425", "Female", "Trujillo"),
        User("Fernando", "Guerrero", "10/12/1981", "fernando.guerrero@example.com", "pass1234", "26272829", "Male", "Chiclayo"),
        User("Natalia", "Vega", "30/08/1999", "natalia.vega@example.com", "password456", "30313233", "Female", "Lima"),
        User("Manuel", "Morales", "04/02/1987", "manuel.morales@example.com", "qwerty123", "34353637", "Male", "Arequipa"),
        User("Camila", "Flores", "23/06/1994", "camila.flores@example.com", "admin1234", "38394041", "Female", "Cusco"),
        User("David", "Castro", "11/11/1983", "david.castro@example.com", "mypassword", "42434445", "Male", "Trujillo"),
        User("Andrea", "Ortiz", "28/07/1998", "andrea.ortiz@example.com", "securepass", "46474849", "Female", "Chiclayo"),
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
        User("Victor", "Huaman", "30/01/1993", "victor.huaman@example.com", "mypassword", "90919293", "Male", "Lima"),
        User("Ariana", "Salazar", "18/07/1985", "ariana.salazar@example.com", "securepass", "94959697", "Female", "Arequipa"),
        User("Martin", "Rivas", "05/05/1999", "martin.rivas@example.com", "pass12345", "98990001", "Male", "Cusco"),
        User("Cecilia", "Quispe", "24/10/1980", "cecilia.quispe@example.com", "password987", "02030405", "Female", "Trujillo"),
        User("Omar", "Espinoza", "17/03/1996", "omar.espinoza@example.com", "qwerty123", "06070809", "Male", "Chiclayo"),
        User("Fernanda", "Garcia", "08/01/1988", "fernanda.garcia@example.com", "admin1234", "10111213", "Female", "Lima"))
    fun CreateUser(user: User){
        users.add(user)
    }
    fun GetUser(correo: String):User?{
        val tempUser = users.find {
            it.correo==correo
        }
        if(tempUser!=null){
            return tempUser
        }else{
            return null
        }
    }
    fun Login(correo:String,contrasena:String):Boolean{
        val loggedUserTemp = users.find {
            correo==it.correo && contrasena==it.contrasena
        }
        return if(loggedUserTemp!=null){
            loggedUser.value=loggedUserTemp
            true
        }else{
            false
        }
    }

    fun Get11Random():List<User>{
        return users.subList(0,12)
    }
}