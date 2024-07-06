# Decisiones de diseño

| Codigo | Decisión de diseño                                                                                             | Fundamentación                                                                                                                                                       |
|--------|----------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| DEC-07 | El submódulo de gestión de partido obtendrá la data necesaria de una base de datos relacional y otra no relacional | Debido a que es importante optimizar la carga de data, se desplegarán dos bases de datos (SQL y NoSQL) en las cuales se tendrá data complementaria.                   |
| DEC-08 | Para la data en tiempo real, se optimizarán las peticiones utilizando funciones Lambda y una división de responsabilidades por microservicios. | Esto asegura que las responsabilidades de los partidos y la transmisión de datos en tiempo real no se vea afectada por la alta concurrencia de usuarios y cumplimos con la restricción de CON-4 |
| DEC-09 | La optimización del streaming de data será realizado mediante Apache Kafka                                        | Para asegurar la calidad y tiempo de respuesta de las actualizaciones realizadas en el sistema de partidos en vivo, se utilizará el patrón pub-sub que cumple con las preocupaciones a nivel de arquitectura de CRN02, CRN03, CRN04. |


## Diagrama Pub Sub

![capas](/proyecto/images/ADD/Iteracion2/pubsub.png)

[Volver al inicio](../ADD.md)