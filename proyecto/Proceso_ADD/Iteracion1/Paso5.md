# Elementos de arquitecturas y asignacion de responsabilidades

| Código  | Decisión de diseño                                            | Fundamentación                                                                                                                                                 |
|---------|---------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| DEC-07  | Desplegar las funciones de llamado a servicios en AWS Lambdas | Al utilizar las funciones de AWS Lambdas se tienen funciones sin servidor que tienen un costo escalable por la utilización de las mismas y tienen un desarrollo ágil y rápido. |
| DEC-08  | Los frameworks para la generación de tokens                   | Los frameworks utilizado para la generación de tokens (JWT) serán gestionados en la capa de lógica de negocio y guardados en la capa de almacenamiento.          |
[Volver al inicio](../ADD.md)
