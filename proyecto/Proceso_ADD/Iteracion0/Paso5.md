# Paso 5: Instanciar elementos de arquitectura, asignar responsabilidades y definir interfaces

| Código | Decisión de diseño | Fundamentación|
|---|---|---|
DEC-05 | Esctructurar el sistema en 5 módulos: Acceso al sistema, Feed del usuario, Personalización del usuario, Coaching en vivo, Rendimiento del participante | Esto con el fin de poder permitir el trabajo colaborativo y que sea mantenible. De esta forma la modificación del código fuente se puede dar de forma independiente en módulos haciendolo más mantenible. Esto permite el cumplimiento de QA-09. 
DEC-06| Aplicar una base de datos relacional | Esto permite que la aplicación sea modificada para abarcar nuevas funcionalidades en el futuro abarcando QA-14 y CRN-03. Además, permite que se puedan modificar tablas de datos de forma independiente, esto haciendo que se cumpla CON-05.
DEC-07 | Uso de una arquitectura de diseño de código MVI | Esto permite que la aplicación se separa la parte de componentes visuales y componentes de obtención/guardado de datos. Esto hace que sea más flexible en añadir/modificar funcionalidades de forma independiente, cumpliendo QA-14 y QA-09. Por otro lado, se cumple CRN-03.