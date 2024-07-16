# Elementos de arquitecturas y asignacion de responsabilidades

| Código  | Decisión de diseño                                           | Fundamentación                                                                                                                                                          |
|---------|--------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| DEC-16  | Desplegar las funciones de llamado a servicios en AWS Lambdas | Al utilizar las funciones de AWS Lambdas se tienen funciones sin servidor que tienen un costo escalable por la utilización de las mismas y tienen un desarrollo ágil y rápido. |
| DEC-17  | Utilización de microservicios para dividir submódulos         | Debido a que la aplicación utiliza módulos de dashboard, manejo previo de partidos y streaming de partidos en curso, es necesario que según la demanda, se pueda escalar las capacidades técnicas de los servicios disponibles. |
| DEC-18  | Se utilizará pub-sub con kafka                                | Se hará uso de Apache Kafka para crear pipes exclusivos de partidos para poder mantener actualizada a las personas que están suscritas a un partido o equipo en específico. |


[Volver al inicio](../ADD.md)