# Elementos de arquitecturas y asignacion de responsabilidades

| Código  | Decisión de diseño                                            | Fundamentación                                                                                                                                                 |
|---------|---------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| DEC-04  | Desplegar las funciones de llamado a servicios en AWS Lambdas | Al utilizar las funciones de AWS Lambdas se tienen funciones sin servidor que tienen un costo escalable por la utilización de las mismas y tienen un desarrollo ágil y rápido. |
| DEC-05  | Se utilizará una arquitectura de capas                        | El utilizar una arquitectura de capas ayudará a separar preocupaciones, mejorar la mantenibilidad del código, escalar los servicios de forma flexible y mejorar ampliamente la seguridad en la comunicación entre capas. |
| DEC-06  | Los frameworks para la generación de tokens                   | Los frameworks utilizado para la generación de tokens (JWT) serán gestionados en la capa de lógica de negocio y guardados en la capa de almacenamiento.          |
[Volver al inicio](../ADD.md)