# Elementos de arquitecturas y asignacion de responsabilidades

| Código | Decisión de diseño | Fundamentación |
| ------ | ------------------ | -------------- |
| DEC-15 | Cada funcionalidad será designada a una escena, encapsulando su integración del patrón MVI | Al dividir la creación de las interfaces por funcionalidades se vuelve más sencillo realizar cambios y mejoras al apartado visual de la aplicación |
| DEC-16 | La capa de datos y conectividad a servicios sera desacoplada mediante el uso de interfaces | Esto permite no depender de implementaciones concretas de repositorios de datos, logrando facilitar la prueba del apartado visual centrandose en la usabilidad |
| DEC-17 | Se utilizaran clases de datos que reflejan las entidades de dominio | Al realizar esto se tiene un reflejo de los datos que se esperan por parte de las demás partes de la infraestructura, permitiendo dirigir la información de mejor manera al usuario final |
| DEC-18 | Los datos que provienen por parte del usuario deben cumplir las restricciones planteadas por los servicios | Esto permite una congruencia entre el servidor y el cliente, evitando errores y mejorando la experiencia de usuario |

[Volver al inicio](../ADD.md)
