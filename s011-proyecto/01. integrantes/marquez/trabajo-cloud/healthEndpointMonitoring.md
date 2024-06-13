# Health Endpoint Monitoring

El patrón de supervisión de estado de los puntos de conexión especifíca el uso de comprobaciones sobre las difentes funcionalidades que una aplicación puede ofrecer. Diferentes herramientas externas pueden acceder a dichas comprobaciones y verificar el estado de salud mediante puntos de conexión expuestos. Las comprobaciones pueden ser realizadas periódicamente.

## Contexto y problema

La supervisión de las aplicaciones web y los servicios back-end es crucial para su correcto funcionamiento y disponibilidad. Esta permite identificar y solucionar problemas de manera oportuna.

Esta acción de vigilancia en la nube puede complicarse debido a la falta de control total sobre el entorno de alojamiento y la dependencia de otros servicios proporcionados por el proveedor de la plataforma.

Es fundamental monitorear continuamente el rendimiento, la disponibilidad y la latencia de las aplicaciones en la nube, así como los sistemas subyacentes de procesamiento, almacenamiento y ancho de banda de red, para evitar errores parciales o totales del servicio. El nivel de supervisión requerido puede estar especificado en el acuerdo de nivel de servicio (SLA).

## Solución

Por lo general, la supervisión es realizada meddiaante la conexión a un punto de la aplicación. Al llamarlo, se realizan las comprobaciones necesarias y se retorna el estado de los servicios consultados.

Se combinan dos factores:

- Las comprobaciones que realiza el servicio
- El análisis de los resultados obtenidos

El código de respuesta determina el estado de la aplicación o servicio, aunque tambien puede representar algún servicio alternativo o componente. El framework o herramienta de supervisión comprueba el tiempo de respuesta

### Comprobaciones habituales

- Código de respuesta: Generalmente, un código 200 indica que no existen errores en el servicio. Se puede establecer una jerarquía de códigos según las necesidades
- Contenido de la respuesta: Es posible que se necesite verificar apartados específicos de la aplicación o servicio consultado
- Tiempo de respuesta: Incluye la latencia de red y el tiempo de ejecución de la aplicación
- Comprobación de recursos o servicios externos: Servicios como una CDN o una base de datos
- Estado de certificados TLS
- Tiempo de respuesta de búsqueda de DNS
- Validación de URL devuelta por DNS

### Localización

Es buena práctica realizar las verificaciones y comprobaciones desde diferentes localizaciones, basándose en la localización del cliente de consulta. Esto permite obtener una idea del rendimiento general del servicio frente a diferentes ubicaciónes globales. Los resultados pueden ayudar sobre las siguientes decisiones:

- Dónde se va a hospedar la aplicación o servicios
- Si va a existir más de un centro de datos

## Problemas y consideraciones

1. Debe planificarse cómo se validará la respuesta: La comprobación minima sería la validación del código de estado 200, pero podrían utilizarse métricas personalizadas para determinar con mayor precisión el estado de la aplicación o servicio.
2. Planificación de los puntos de conexión expuestos: Debe determinarse cuantos puntos de conexión serán expuestos para realizar las comprobaciones, así como que validaciones corresponden a cada uno. Podría tenerse uno general para todos, o se podría optar por una solución más granular con un punto por servicio. Debe considerarse el rendimiento, los tiempos de respuesta y los tipos de servicios involucrados.
3. Decidir si el punto de conexión para la supervisión y para el acceso general serán los mismos
4. Determinar que información será recopilada en el servicio cuando se solicite una supervisión. Esto puede variar según que tan personalizada se desea que la respuesta sea
5. Establecer cuánta información será recopilada. Excederse a la hora de evaluar puede perjudicar la experiencia de los usuarios regulares.
6. Considerar el uso de caché para almacenar el estado del punto de conexión. Puede utilizarse un servicio alterno que realice consultas periódicas y almacene las validaciones. De esta forma se evita sobrecargar el punto con consultas al momento
7. Planear la configuración de seguridadd de los puntos de supervisión. Es necesario proteger el puerto de ataques comunes, tales como robo de información confidencial, denegación de servicio o ataques malintencionados en general.
8. Decidir como asegurarse que el agente o servicio de supervisión funciona correctamente.

## Cuándo usar este patrón

- Comprobar disponibilidad de sitios y aplicaciones web
- Comprobar el funcionamiento esperado y correcto de sitios y aplicaciones web
- Supervisar servicios de nivel intermedio o que sean compartidos por otras aplicaciones e identificar posibles errores
- Complementar marcos de auditoría que ya verifiquen aspectos como el rendimiento o errores, pero no la disponibilidad

# Demo

Drive Ulima: https://drive.google.com/file/d/112wiGmSrm3h61WYd2pjVzc6gBf0lMzpF/view?usp=sharing

# Referencias

1. https://learn.microsoft.com/es-es/azure/architecture/patterns/health-endpoint-monitoring