# Modulo 1: Overview de partidas deportivas
*Requerimientos funcionales*
1. Selección de tipo de usuario:
- El cliente debe seleccionar el tipo de usuario que desea cumplir dentro del aplicativo
- En caso el tipo de usuario necesita un acceso especial deberá ingresar un código de invitación
2. Creación de acceso:
- En caso el usuario no exista, deberá ingresar sus credenciales de usuario
- En caso el usuario no exista, deberá ingresar un código de verificación
- En el usuario exista, se deberá colocar las credenciales existentes de acceso
- En caso el usuario no quiera generar un acceso con credenciales y quiere visualizar el app sin iniciar sesión o registrarse, el usuario puede ingresar al overview con funcionalidades limitadas 
3. Segmentación de usuarios:
- Mostrar las vistas de menús acorde al tipo de usuario accedido 
- Mostrar las funcionalidades disponibles acorde al tipo de usuario accedido
4. Visualización de partidos:
- Mostrar los partidos en base al tipo de usuario accedido
- Mostrar partidos propios de un equipo afiliado
- Priorizar el contenido del equipo afiliado
- Mostrar partidos de terceros 
- Mostrar detalles de los partidos como lugar de cancha, participantes, minutos, cantidad de jugadores disponibles, nombre del partido 
5. Pantalla de adición de partidas deportivas: 
- Mostrar una pantalla con un campo a rellenar donde se ingresa un código del partido respectivo
- Mostrar si la adición ha sido éxitosa
- Recargar la vista acorde al partido añadido

### Requerimientos de atributos de calidad

*Rendimiento:*

Escenario: Acceso concurrente de múltiples managers al panel de control durante la venta de tickets para eventos populares.
Estímulo: Managers autenticados acceden al panel de control para gestionar eventos.
Fuente del estímulo: Múltiples managers ingresan al panel de control simultáneamente.
Respuesta: El sistema debe responder a las solicitudes de acceso al panel de control de manera eficiente, sin demoras significativas.
Medida de respuesta: Tiempo promedio de respuesta del sistema cuando hay múltiples managers activos, no debe exceder los 5 segundos.
Entorno: Alta demanda durante la venta de tickets para eventos populares.
Artefacto: Panel de Managers.

*Funcionalidad:*

Escenario: Selección de tipo de usuario.
Estímulo: El cliente selecciona el tipo de usuario que desea utilizar.
Fuente del estímulo: El cliente interactúa con la interfaz de usuario.
Respuesta: El sistema debe permitir al cliente seleccionar correctamente el tipo de usuario deseado.
Medida de respuesta: El 100% de los usuarios deben poder seleccionar el tipo de usuario correctamente.
Entorno: Cualquier dispositivo con acceso a internet.
Artefacto: Interfaz de selección de tipo de usuario.

*Usabilidad:*

Escenario: Creación de acceso.
Estímulo: El usuario crea un nuevo acceso o inicia sesión en un acceso existente.
Fuente del estímulo: El usuario interactúa con la interfaz de usuario.
Respuesta: El sistema debe proporcionar una interfaz de usuario intuitiva y fácil de usar para la creación de acceso e inicio de sesión.
Medida de respuesta: El 95% de los usuarios deben poder crear un nuevo acceso o iniciar sesión en un acceso existente sin necesidad de asistencia.
Entorno: Cualquier dispositivo con acceso a internet.
Artefacto: Interfaz de creación de acceso e inicio de sesión.

*Seguridad:*

Escenario: Segmentación de usuarios.
Estímulo: El usuario accede al sistema.
Fuente del estímulo: El sistema autentica al usuario.
Respuesta: El sistema debe mostrar las vistas de menús y las funcionalidades disponibles de acuerdo al tipo de usuario autenticado.
Medida de respuesta: El 100% de los usuarios deben ver las vistas de menús y las funcionalidades disponibles de acuerdo a su tipo de usuario.
Entorno: Cualquier dispositivo con acceso a internet.
Artefacto: Sistema de segmentación de usuarios.

*Confiabilidad:*

Escenario: Visualización de partidos.
Estímulo: El usuario accede a la sección de visualización de partidos.
Fuente del estímulo: El sistema consulta la base de datos para obtener la información de los partidos.
Respuesta: El sistema debe mostrar la información de los partidos de manera completa, precisa y actualizada.
Medida de respuesta: El 99.9% de los partidos deben ser mostrados de manera completa, precisa y actualizada.
Entorno: Cualquier dispositivo con acceso a internet.
Artefacto: Módulo de visualización de partidos.

*Mantenibilidad:*

Escenario: Pantalla de adición de partidas deportivas.
Estímulo: El usuario ingresa un código de partido para agregar una nueva partida.
Fuente del estímulo: El usuario interactúa con la interfaz de usuario.
Respuesta: El sistema debe permitir al usuario ingresar el código de partido correctamente y mostrar un mensaje de confirmación si la adición ha sido exitosa.
Medida de respuesta: El 100% de los usuarios deben poder ingresar el código de partido correctamente y ver el mensaje de confirmación si la adición ha sido exitosa.
Entorno: Cualquier dispositivo con acceso a internet.
Artefacto: Pantalla de adición de partidas deportivas.

### Restricciones: 
1. Frontend:
- Restricción: Implementación en Android Kotlin y Swift UI (IOS)
- Justificación: Son los dos sistemas operativos móviles más utilizados en el mercado y estos lenguajes de programación son los más modernos actualmente. Potencialmente no necesitará migración en un tiempo prolongado. Tiene acceso nuevas tecnologías y es óptimo para nuevos dispositivos. 
2. Backend:
- Restricción: Uso de GraphQl como API de acceso a los servicios de base de datos
- Justificación: GraphQl se encuentra como tendencia por alta flexibilidad

# Modulo 2: Personalización de usuario
# Modulo 3: Coaching en vivo
# Modulo 4: Rendimiento del participante
