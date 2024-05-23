# Tácticas

## Disponibilidad
### Módulo 0: Acceso al sistema
- **Escenario:** Un usuario ha comprado un nuevo celular y desea conocer el estado de su equipo a media noche, el celular es Android y no cuenta con ningún aplicativo

> **Táctica:** Prevenir fallas

- Remover el servicio: Colocar un anuncio de "fuera de servicio" si es que el servicio fuese a fallar o estar caído dado un problema interno del servidor o los sistemas conectados. 
- Prevención de excepciones: Tener un aplicativo que pueda manejar una variedad de errores sin caerse y que sea capaz de registrar los fallos y/o mostrar avisos del potencial fallo al usuario. 
- Modelos predictivos: Adquirir o implementar un sistema de monitoreo que permita tener el control sobre la cantidad de usuarios conectados o haciendo solicitudes al mismo tiempo y el estrés que este implica. Este modelo podría mostrar potenciales fallas o caídas en caso de que el sistema este sobrepasando sus capacidades actuales. 


### Módulo 3: Coaching en Vivo
- **Escenario:** Una persona esta gestionando un partido en vivo y desea marcar el medio tiempo del partido. Esto es porque quiere establecer el tiempo de descanso de los atletas y que los aficionados del equipo sepan que tienen tiempo para reincorporarse dentro de unos minutos

> **Táctica:** Recuperarse de fallas

- Actualizaciones de software: Se posee de la capacidad de notificar al usuario de que debe actualizar el aplicativo si es que se ha generado una corrección del sistema o si es que se han modificado aspectos cruciales del aplicativo y que potencialmente podrían prevenir errores en relación a los partidos en vivo. 
- Redundancia Activa (hot spare): Se ejecutan las acciones que solicita el usuario en un número determinado de nodos, en caso uno de estos fallo, otro nodo se encargará de tomar su lugar en milisegundos en caso de fallas. 
- Manejo de Excepciones: La aplicación reconoce una gran cantidad de potenciales errores y provee aviso y soluciones ante ellas. Esto es importante durante un partido en vivo, dado que si hay un fallo de red se podría perder data muy importante en relación al partido y potencialmente arruinar todo el registro. Si se maneja la excepción de forma correcta se puede pasar a un registro offline y se pueda subir a la nube una vez que el usuario recupere su acceso al internet.


## Mantenibilidad
### Módulo 1: Feed del usuario
- **Escenario:**  En una futura iteración de la aplicación Atlestats, se dispone de una nueva fuente de datos para la información de los partidos. La aplicación debe actualizarse para incorporar esta nueva fuente de datos manteniendo la compatibilidad con las fuentes existentes.

> **Táctica:** Disminuir acoplamiento

- Refactoring: Si es que dos modulos se ven afectados por un solo cambio significa que se deben cambiar estas partes del código para que no depender de uno del otro y tengan tareas claramente asignadas. 
- Abstraer servicios comunes: Si es que los módulos tienen distintos roles pero cuentan con funciones similares significa que deben ser implementados de forma más general o abstracta. Asi se no existe la necesidad de modificar funciones similares, esto resulta crucial si es que se desea cambiar fuentes de datos dado que este podría tener cambios en múltiples partes del código. 

### Módulo 2: Personalización de usuario
- **Escenario:** Los diseñadores necesitan actualizar la interfaz de usuario del perfil de usuario para adaptarla a un nuevo estilo de diseño.

> **Táctica:** Parametrización

- Destinar archivo de configuración con todos los colores, strings de contenido de partes estáticas y tamaños de imágenes para que estos puedan ser modificados en una parte del código si es que se desean hacer cambios drásticos en el diseño. Para esto se deben establecer reglas de negocio para establecer las variables destinadas a aspectos reutilizables en el diseño como los colores corporativos, textos y tamaños de imágen (dependiendo del dispositivo). 

## Rendimiento

### Modulo 0:

	Se buscará incrementar la eficiencia en el uso de recursos, dado que al seguir dicha directiva se puede optimizar el proceso de registro por parte del servicio mismo. Esto implicaría menores tiempos de espera y latencia, además de un menor tamaño de datos enviados hacia y por parte del servidor si es que se aplica buenas practicas entre la comunicación cliente-servidor. Estos puntos favorecerían una conectividad pobre por parte de algún usuario, al ser menor el tamaño de la información transmitida y el tiempo de conexión.

### Modulo 3:

	Esto se justifica porque la introducción de concurrencia permite manejar múltiples solicitudes y eventos en paralelo, reduciendo el tiempo de bloqueo y asegurando una reproducción de video fluida y sin interrupciones. Al utilizar múltiples hilos de ejecución, la aplicación puede procesar la reproducción en tiempo real de manera más eficiente, respondiendo instantáneamente a los comandos del entrenador y manejando la visualización simultánea de múltiples jugadores y eventos sin comprometer la calidad.

### Modulo 4:

	Al mantener múltiples copias de los datos en almacenamiento con diferentes velocidades de acceso (por ejemplo, uso de caché) permite que la aplicación acceda rápidamente a la información necesaria, minimizando el tiempo de carga incluso con una conexión lenta.

## Usabilidad

### Modulo 0: TODO

### Modulo 1:TODO

### Modulo 2:TODO

### Modulo 3:TODO

### Modulo 4:TODO

## Seguridad

(Matias)
Modulo 0:

	En primer lugar, autenticar a los actores es fundamental para garantizar que solo los usuarios legítimos puedan acceder al sistema y realizar operaciones críticas, como ingresar datos personales, cargar imágenes y vincularse a un equipo. Implementar contraseñas seguras, que cumplan con criterios de longitud y complejidad, es una medida básica pero efectiva para prevenir accesos no autorizados. La autenticación en dos pasos añade una capa adicional de seguridad, al requerir un código temporal enviado al dispositivo móvil o correo electrónico del usuario, lo que reduce significativamente el riesgo de acceso no autorizado, incluso si la contraseña ha sido comprometida.

	Otra táctica crucial es autorizar a los actores para asegurar que cada usuario tenga acceso solo a las funcionalidades y datos necesarios según su rol dentro de la aplicación. Implementar un sistema de control de acceso basado en los diferentes tipos de usuarios permite definir roles específicos, como usuario estándar, administrador y miembro del equipo, y asignar permisos adecuados a cada uno. Esto garantiza que solo los usuarios autorizados puedan realizar ciertas acciones, como modificar datos personales o acceder a información confidencial del equipo.

Modulo 2:

TODO

Respuesta

Modulo 1: TODO

Modulo 3: TODO



