# Modulo 0: Acceso al sistema

![Modulo 0](../proyecto/images/requerimientosImagenes/Login.png)

## *Requerimientos funcionales*

**1. Selección de tipo de usuario:**
- El cliente debe seleccionar el tipo de usuario que desea cumplir dentro del aplicativo
- En caso el tipo de usuario necesita un acceso especial deberá ingresar un código de invitación

**2. Creación de acceso:** 
- En caso el usuario no exista, deberá ingresar sus credenciales de usuario
- En caso el usuario no exista, deberá ingresar un código de verificación
- En el usuario exista, se deberá colocar las credenciales existentes de acceso
- En caso el usuario no quiera generar un acceso con credenciales y quiere visualizar el app sin iniciar sesión o registrarse, el usuario puede ingresar al overview con funcionalidades limitadas 

## *Requerimientos no funcionales*

### Rendimiento:

- **Escenario:** Un cliente nuevo intenta registrarse en la aplicación por primera vez en un dispositivo móvil con una conexión a internet lenta.

- **Estímulo:** El cliente ingresa sus datos personales y crea una cuenta de usuario.

- **Fuente de estímulo:** La necesidad del cliente de acceder al sistema por primera vez.

- **Artefacto:** Aplicación Atlestats en un dispositivo móvil con conexión a internet lenta.

- **Respuesta:** La aplicación debe optimizar el proceso de registro para minimizar el tiempo de espera y la cantidad de datos transferidos, incluso en dispositivos con conectividad limitada. La aplicación debe mostrar indicadores de progreso y evitar bloqueos o interrupciones durante el registro.

- **Medida de respuesta:** Tiempo de carga del formulario de registro, ausencia de retrasos o interrupciones durante el proceso de registro, y capacidad para funcionar correctamente con conexiones a internet lentas.

### Usabilidad:

- **Escenario:** Un usuario nuevo, que no está familiarizado con la aplicación, necesita iniciar sesión por primera vez.

- **Estímulo:** El usuario ingresa su nombre de usuario y contraseña en la pantalla de inicio de sesión.

- **Fuente de estímulo:** La necesidad del usuario de acceder a su cuenta por primera vez.

- **Artefacto:** Pantalla de inicio de sesión de la aplicación Atlestats.

- **Respuesta:** La pantalla de inicio de sesión debe ser clara, intuitiva y fácil de usar, incluso para usuarios nuevos o con poca experiencia técnica. La aplicación debe proporcionar instrucciones claras, ayudas contextuales y la opción de recuperar la contraseña en caso de que el usuario la haya olvidado.

- **Medida de respuesta:** Tiempo que tarda el usuario en iniciar sesión por primera vez, facilidad de uso de la pantalla de inicio de sesión y satisfacción del usuario con la claridad y la organización de la interfaz.

### Seguridad:

- **Escenario:** Un usuario intenta iniciar sesión en su cuenta con una contraseña incorrecta en varias ocasiones.

- **Estímulo:** El usuario ingresa una contraseña incorrecta repetidamente.

- **Fuente de estímulo:** Un posible intento de acceso no autorizado a la cuenta del usuario.

- **Artefacto:** Mecanismo de autenticación de usuario en la aplicación Atlestats.

- **Respuesta:** La aplicación debe implementar un mecanismo de autenticación seguro que bloquee la cuenta del usuario después de un número determinado de intentos fallidos de inicio de sesión. La aplicación debe notificar al usuario sobre el bloqueo de la cuenta y proporcionar instrucciones para desbloquearla.

- **Medida de respuesta:** Efectividad del mecanismo de autenticación para prevenir accesos no autorizados, tiempo que tarda el usuario en desbloquear su cuenta y facilidad del proceso de desbloqueo.

### Disponibilidad:

- **Escenario:** Un usuario ha comprado un nuevo celular y desea conocer el estado de su equipo a media noche, el celular es Android y no cuenta con ningún aplicativo

- **Estímulo:** El usuario descarga la aplicación de AtleStat en Android y desea ingresar sesión poco después de media noche, el acceso al sistema falla en generar las credenciales posterior a la media noche 

- **Fuente de estímulo:** Un intento de ingreso de usuario realizado después de media noche en un aplicativo sin credenciales de usuario guardadas. 

- **Artefacto:** Mecanismo de autentificación 

- **Respuesta:** Incrementar la capacidad del servidor y solucionar potenciales errores con el sistema de credenciales. Potencialmente adquirir un servicio de base de datos más confiable

- **Medida de respuesta:** Cantidad de acceso al sistema fallidos

# Modulo 1: Feed del usuario

![Modulo 1](../proyecto/images/requerimientosImagenes/Feed.png)

## *Requerimientos funcionales*
**1. Enseñar partidos:** 
- El usuario podrá visualizar los partidos próximos en caso de que este afiliado a un equipo. Si es que este no esta vinculado a un equipo, este no podrá visualizar los partidos que se aproximan de su equipo.
- El usuario podrá visualizar los partidos pasados en caso de que este afiliado a un equipo. Si es que no esta vinculado a un equipo, este no podrá visualizar los partidos pasados del equipo. Si es que esta afiliado a un equipo y no tiene partidos aún o no participado en ninguno, no tendrá partidos pasados.  Los partidos pasados sirven como un historial de cómo se desempeño el usuario o el equipo del usuario.

**2. Calendario de actividades:**
- El usuario podrá visualizar los partidos/entrenamientos/eventos relacionados al equipo vinculado dentro de un calendario de actividades. Este calendario anota estos eventos importantes y se vincula al detalle de la actividad.

**3. Filtro de equipos:**
- El usuario podrá filtrar los partidos a partir de un filtro de equipos. Esto se debe a que el usuario puede ser un jugador o coach y este puede pertenecer a múltiples equipos, se desea que el usuario pueda visualizar lo que es de su interés. 

## *Requerimientos no funcionales*

### Respuesta

Se desea que el feed del usuario tenga una tiempo de respuesta que se ajuste a la necesidad del usuario. Dado que es un app deportiva, cuando el usuario ingresa al app desea tener información de su rendimiento o ver el desempeño del partido en vivo. Esta respuesta debe darse en menos de un par de segundos porque probablemente el usuario acceda al app en pleno partido o lo más cercano a la finalización del partido. 

- **Escenario:** El usuario visualiza el app pocos minutos posterior al partido de su equipo y desea acceder al partido en la parte de partidos pasados. 

- **Estímulo:** El internet de su ubicación es lento por lo que el app tarda en actualizarse

- **Fuente de estímulo:** Internet de la ubicación del usuario

- **Artefacto:** Feed del usuario 

- **Respuesta:** El app muestra un aviso de que el internet es lento y no se ha podido proceder con la actualización. Solicita una recarga cuando el internet se establilice. Sin embargo, se muestran los partidos que se han guardado en memoria local para que pueda seguir explorando el app incluso sin internet.  

- **Medida de respuesta:** Tiempo de respuesta de recarga/ Tiempo total en el app

### Usabilidad 

La segmentación del feed debe tener un sentido lógico que el usuario puede adquirir la información de los partidos en un orden dependiendo de la relevancia de los eventos que esten ocurriendo. 

- **Escenario:** El usuario desea encontrar rápidamente el resultado del último partido de su equipo.
  
- **Estímulo:** El usuario abre la sección "Partidos pasados" del feed.

- **Fuente de estímulo:** El deseo del usuario de encontrar el resultado del último partido.
  
- **Artefacto:** El feed del usuario de la aplicación Atlestats.

- **Respuesta:** La aplicación debe mostrar de manera prominente el último resultado del partido para el equipo del usuario, lo que facilita que lo encuentren sin tener que desplazarse por una larga lista de otros partidos.

- **Medida de respuesta:** Tiempo que tarda el usuario en encontrar el resultado del último partido.
Satisfacción del usuario con la organización y presentación de los resultados del partido.

### Mantenibilidad 

El feed del usuario es algo que se va a utilizar en todas las iteraciones del aplicativo. Por ello, se desea que el aplicativo sea mantenible por el lado del software, se pueda modificar y añadir elementos a la estructura del feed en las próximas iteraciones. 

- **Escenario:** En una futura iteración de la aplicación Atlestats, se dispone de una nueva fuente de datos para la información de los partidos. La aplicación debe actualizarse para incorporar esta nueva fuente de datos manteniendo la compatibilidad con las fuentes existentes.

- **Estímulo:** El equipo de desarrollo decide integrar la nueva fuente de datos de información de partidos en el feed del usuario.

- **Fuente de estímulo:** La decisión de mejorar la aplicación con la nueva fuente de datos.

- **Artefacto:** El código del feed del usuario de la aplicación Atlestats.

- **Respuesta:** 
  - Crear un nuevo módulo para la nueva fuente de datos: Encapsular la lógica de interacción con la nueva fuente de datos en un módulo separado, manteniéndola aislada de los componentes existentes del feed.
  - Definir un nuevo modelo de datos: Crear un nuevo modelo de datos para representar la información de los partidos de la nueva fuente de datos. Este modelo debe ser compatible con los modelos de datos existentes utilizados por el feed.
  - Actualizar la capa de presentación del feed: Mejorar la capa de presentación del feed para manejar la nueva información de los partidos. Esto puede implicar la creación de nuevos componentes de la interfaz de usuario o la adaptación de los existentes.

- **Medida de respuesta:** 
  - Tiempo empleado en completar la integración de la nueva fuente de datos.
  - Número de errores introducidos durante el proceso de integración.
  - Estabilidad y rendimiento general de la aplicación tras la integración.


# Modulo 2: Personalización de usuario
![Modulo 2](../proyecto/images/requerimientosImagenes/Personalizar.png)

## *Requerimientos funcionales*

**1. Ingreso de datos personales:** 

- El usuario debe poder ingresar sus datos personales, como nombre, apellido, correo electrónico y fecha de nacimiento.

**2. Carga de imágenes:** 

- El usuario debe poder cargar una imagen de perfil para personalizar su cuenta.

**3. Vinculación de equipo:** 

- El usuario debe poder vincularse a un equipo para acceder a información específica del equipo y participar en funciones comunitarias.

## *Requerimientos no funcionales*

### Seguridad

Los datos personales del usuario deben almacenarse de forma segura y protegida contra el acceso no autorizado. La aplicación debe implementar medidas de seguridad adecuadas para proteger las imágenes cargadas por los usuarios. La vinculación del equipo debe realizarse de forma segura para evitar la suplantación de identidad o el acceso no autorizado a información confidencial del equipo.

- **Escenario:** El usuario ingresa sus datos personales al crear una cuenta.

- **Estímulo:** El usuario completa el formulario de registro de usuario.

- **Fuente de estímulo:** La acción del usuario de proporcionar información personal.

- **Artefacto:** Formulario de registro de usuario en la aplicación Atlestats.

- **Respuesta:** La aplicación debe emplear medidas de seguridad sólidas para proteger los datos personales del usuario, como cifrado de datos, autenticación segura y controles de acceso estrictos. La aplicación debe cumplir con las normas y regulaciones de privacidad de datos aplicables, como la GDPR.

- **Medida de respuesta:** Nivel de seguridad de los datos personales del usuario, incluyendo la ausencia de vulnerabilidades o filtraciones de datos.

### Usabilidad 

El proceso de ingreso de datos personales debe ser sencillo y directo, con instrucciones claras y campos fáciles de identificar. La interfaz de carga de imágenes debe ser fácil de usar y permitir al usuario seleccionar y cargar imágenes sin problemas. La opción de vinculación de equipo debe ser intuitiva y permitir al usuario encontrar y unirse a su equipo fácilmente.

- **Escenario:** El usuario desea actualizar su imagen de perfil con una foto más reciente.

- **Estímulo:** El usuario toca el icono de su imagen de perfil en la aplicación.

- **Fuente de estímulo:** El deseo del usuario de actualizar su imagen de perfil.

- **Artefacto:** Opción de edición de imagen de perfil en la aplicación Atlestats.

- **Respuesta:** La aplicación muestra una interfaz que permite al usuario seleccionar una nueva imagen de su dispositivo y cargarla como su imagen de perfil. La aplicación debe mostrar una vista previa de la imagen antes de cargarla para que el usuario pueda asegurarse de que está satisfecho con el resultado.

- **Medida de respuesta:** Tiempo que tarda el usuario en actualizar su imagen de perfil.


### Mantenibilidad 

El código relacionado con la personalización del usuario debe estar bien organizado y documentado para facilitar su mantenimiento y futuras mejoras.La aplicación debe diseñarse de forma modular para permitir la adición de nuevas funciones de personalización en el futuro.Los datos de personalización del usuario deben almacenarse en un formato estructurado y accesible para facilitar su consulta y análisis.

- **Escenario:** Los diseñadores necesitan actualizar la interfaz de usuario del perfil de usuario para adaptarla a un nuevo estilo de diseño.

- **Estímulo:** El equipo de diseño decide renovar la apariencia de la aplicación.

- **Fuente de estímulo:** La necesidad de mantener la aplicación actualizada y atractiva para los usuarios.


# Modulo 3: Coaching en vivo
![Modulo 3](../proyecto/images/requerimientosImagenes/Coaching%20en%20vivo.png)


## *Requerimientos funcionales*

**1. Visualización de información:** 

- El entrenador debe poder visualizar la estructura del equipo, incluyendo la lista de jugadores, sus posiciones y roles dentro del equipo.
- El entrenador debe poder visualizar los partidos que se van a jugar y la hora de inicio de cada uno.

**2. Configuración del equipo y partido:** 

- El entrenador debe poder agregar y editar a los jugadores.
- El entrenador debe poder editar las posiciones de los jugadores y poder reflejar los cambios que ha hecho durante el partido en el aplicativo.
- El entrenador debe poder iniciar o finalizar el partido.
- El entrenador del equipo debe contar con una sección en la que pueda realizar apuntes individuales por cada jugador durante la sesión de coaching en vivo.

**3. Ejecución y monitoreo de sesiones en vivo:** 

- El entrenador debe tener la posibilidad de corroborar que la sesión de coaching en vivo se está ejecutando correctamente y recibiendo información en tiempo real.
-Ele ntrenador tiene la posibilidad de reproducir en tiempo real el partido al que se desea hacer coaching.

## *Requerimientos no funcionales*

### Usabilidad

La interfaz de usuario para la funcionalidad de coaching en vivo debe ser intuitiva y accesible, permitiendo al entrenador gestionar y monitorear las sesiones de forma eficiente. Las diferentes opciones a las que el usuario puede acceder deben estar claramente identificadas y ser fáciles de usar, minimizando la curva de aprendizaje para los usuarios.

- **Escenario:** El entrenador es nuevo en el uso de la aplicación de coaching en vivo.

- **Estímulo:** El entrenador intenta anotar datos del rendimiento individual de un jugador.

- **Fuente de estímulo:** La necesidad del entrenador de utilizar las herramientas de la aplicación de forma efectiva.

- **Artefacto:** Interfaz de usuario de la herramienta de anotación de datos en la aplicación Atlestats.

- **Respuesta:** La aplicación debe proporcionar instrucciones claras y retroalimentación en tiempo real para guiar al entrenador a través del proceso de anotación de datos.

- **Medida de respuesta:** Tiempo que tarda el entrenador en aprender a utilizar las herramientas de la aplicación y completar tareas de coaching básicas.

### Mantenibilidad

El módulo de coaching en vivo de Atlestats debe ser fácilmente mantenible, permitiendo modificaciones y mejoras futuras sin afectar la funcionalidad existente. La arquitectura del módulo debe estar bien diseñada y documentada para que los desarrolladores puedan introducir nuevas características, corregir errores y actualizar componentes con eficiencia y mínima interrupción.

- **Escenario:** El equipo de desarrollo decide integrar una nueva funcionalidad de análisis de estadísticas en tiempo real en el módulo de coaching en vivo.

- **Estímulo:** Integración de nueva funcionalidad de analisis al modulo de coaching en vivo.

- **Fuente de estímulo:** La decisión de mejorar la aplicación con la capacidad de análisis en tiempo real para los entrenadores.

- **Artefacto:** El código del módulo de coaching en vivo de la aplicación Atlestats.

- **Respuesta:** El código de la aplicación debe estar diseñado de forma modular y extensible, permitiendo a los desarrolladores agregar nuevas funciones de análisis sin afectar a la funcionalidad existente. La documentación clara y las pautas de codificación coherentes facilitarán la comprensión y modificación del código por parte de nuevos desarrolladores.

- **Medida de respuesta:** 
- Tiempo que tarda el equipo de desarrollo en agregar una nueva función de análisis a la aplicación.
- Estabilidad y rendimiento general del módulo de coaching en vivo tras la integración.

### Disponibilidad

- **Escenario:** Una persona esta gestionando un partido en vivo y desea marcar el medio tiempo del partido. Esto es porque quiere establecer el tiempo de descanso de los atletas y que los aficionados del equipo sepan que tienen tiempo para reincorporarse dentro de unos minutos

- **Estímulo:** El asistente del entrenador trata de colocar en el aplicativo de que hay un medio tiempo en la aplicación pero esta falla en registrar la acción y no se marca el medio tiempo. 

- **Fuente de estímulo:** Acción del usuario y petitición de modificar un evento de partido.

- **Artefacto:** Interacción entre aplicativo y base de datos, API del aplicativo

- **Respuesta:** Encontrar el error que genero este problema y aplicar medidas preventivas ante este tipo de error. Guardar envios tardios o fallidos y actualizarlos una vez que vuelva a estar en línea. Notificar si es que es el sistema ha tenido un problema

- **Medida de respuesta:** Errores de partidos solucionados entre errores totales relacionados a partidos x 100 

# Modulo 4: Rendimiento del participante

## *Requerimientos funcionales*

**1. Estadisticas del rendimiento del participante:**  

- El entrenador debe poder visualizar estadísticas detalladas del rendimiento individual de cada jugador, incluyendo métricas clave como precisión de pases, efectividad de tiro, porcentaje de rebotes, intercepciones, faltas, entre otras.

**2. Filtro por partidos:** 

- El entrenador debe poder filtrar las estadísticas del rendimiento del participante por partido, permitiendo un análisis más granular del desempeño individual a lo largo de la temporada o torneo.

**3. Oportunidades de mejora:**

- El entrenador debe poder identificar oportunidades de mejora en el rendimiento individual de cada jugador y proporcionar retroalimentación constructiva.

**4. Notas del coach:**  

- El entrenador debe poder agregar notas textuales sobre el rendimiento individual de cada jugador, complementando las estadísticas y observaciones.

## *Requerimientos no funcionales*

### Rendimiento

- **Escenario:** El entrenador está analizando las estadísticas de rendimiento de un equipo completo después de un partido importante, utilizando la aplicación en una tablet con una conexión a internet lenta.

- **Estímulo:** El entrenador carga la sección de estadísticas del rendimiento del participante para ver las métricas de todo el equipo.

- **Fuente de estímulo:** La necesidad del entrenador de acceder a información crucial de forma rápida y eficiente.

- **Artefacto:** Aplicación Atlestats en una tablet con conexión a internet lenta.

- **Respuesta:** La aplicación debe optimizar la carga y presentación de datos para minimizar el tiempo de espera, incluso en dispositivos con conectividad limitada. La aplicación debe mostrar indicadores de progreso y evitar bloqueos o interrupciones durante la carga de datos.

- **Medida de respuesta:** Tiempo de carga de las estadísticas del rendimiento del participante, ausencia de retrasos o interrupciones durante la navegación, y capacidad para funcionar correctamente con conexiones a internet lentas.

### Usabilidad

- **Escenario:** Un nuevo entrenador, que no está familiarizado con la aplicación, necesita analizar el rendimiento individual de un jugador en varios partidos.

- **Estímulo:** El entrenador navega por la sección de estadísticas del rendimiento del participante y utiliza los filtros y opciones de visualización.

- **Fuente de estímulo:** La necesidad del entrenador de aprender a usar la aplicación de manera efectiva para obtener la información deseada.

- **Artefacto:** Interfaz de usuario de la sección de estadísticas del rendimiento del participante en la aplicación Atlestats.

- **Respuesta:** 
  - La interfaz de usuario debe ser intuitiva y fácil de usar, incluso para usuarios nuevos o con poca experiencia técnica. 
  - La aplicación debe proporcionar instrucciones claras, ayudas contextuales y tutoriales para guiar al entrenador a través del proceso de análisis de datos.

- **Medida de respuesta:** 
  - Tiempo que tarda el entrenador en aprender a usar la sección de estadísticas del rendimiento del participante
  - Facilidad de uso de los filtros y opciones de visualización
  - Satisfacción del entrenador con la claridad y la organización de la interfaz.

### Mantenibilidad

- **Escenario:** Los desarrolladores necesitan integrar una nueva fuente de datos de estadísticas de rendimiento de jugadores de una plataforma externa.

- **Estímulo:** El equipo de producto decide ampliar la aplicación para incluir datos de más fuentes.

- **Fuente de estímulo:** La necesidad de evolucionar la aplicación para ofrecer datos más completos y precisos.

- **Artefacto:** Código de la sección de estadísticas del rendimiento del participante en la aplicación Atlestats.

- **Respuesta:** 
  - El código de la aplicación debe estar diseñado de forma modular y extensible, permitiendo a los desarrolladores integrar nuevas fuentes de datos sin afectar a la funcionalidad existente. 
  - La documentación clara y las pautas de codificación coherentes facilitarán la comprensión y modificación del código por parte de nuevos desarrolladores.

- **Medida de respuesta:** 
  - Tiempo empleado en completar la integración de la nueva fuente de datos
  - Número de errores introducidos durante el proceso de integración
  - Estabilidad y rendimiento general de la aplicación tras la integración.

# Restricciones

## *Frontend*

- **Restricción:** Implementación en Android Kotlin y Swift UI (IOS)

- **Justificación:** Son los dos sistemas operativos móviles más utilizados en el mercado y estos lenguajes de programación son los más modernos actualmente. Potencialmente no necesitará migración en un tiempo prolongado. Tiene acceso nuevas tecnologías y es óptimo para nuevos dispositivos.

- **Restricción:**: Uso de Android Studio (Android Kotlin)

- **Justificación:** Es una IDE (Integration Development Environment) integrado con IntelliJ, ideal para el dessarrollo de aplicaciones de Android Kotlin y Java. El IDE tiene funcionalidades que permite la ejecución del código, emulador de aplicación, análisis de rendimiento, logcat, terminal y plugins. 

## *Backend*

- **Restricción:** Uso de GraphQl como API de acceso a los servicios de base de datos

- **Justificación:** GraphQl se encuentra como tendencia por alta flexibilidad

- **Restricción:** Uso de PostGres como base de datos

- **Justificación:** Los desarrolladores de los aplicativos cuentan con experiencia en PostGres y cumplen las capacidades necesarias para el almacenamiento de datos que se necesitan para este proyecto. 

# Decisiones a nivel de arquitectura (planguage)

## Caso de uso 0: Acceso/ Registro de usuario
- Contexto:
- Diseño propuesto:
-  Consideraciones:
- Decisión: 

## Caso de uso 1: Feed de usuario
- Contexto:
- Diseño propuesto:
- Consideraciones:
- Decisión: 

## Caso de uso 2: Personalización de usuario
- Contexto:
- Diseño propuesto:
- Consideraciones:
- Decisión: 

## Caso de uso 3: Gestión de partidos
- Contexto:
- Diseño propuesto:
- Consideraciones:
- Decisión: 

## Caso de uso 4: Rendimiento del participante
- Contexto:
- Diseño propuesto:
- Consideraciones:
- Decisión: 

[**Volver al índice**](../README.md)