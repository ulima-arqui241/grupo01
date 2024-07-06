# Decisiones de diseño

| Codigo | Decisión de diseño                                                                                                            | Fundamentación                                                                                                          |
|--------|-------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| DEC-01 | La estructura lógica del submódulo utilizará un patrón de módulo de arquitectura de capas (sin contar capas de interfaz gráfica), en las cuales se tendrá la capa de almacenamiento, capa de acceso de datos y capa de lógica de negocio | Se utilizará un despliegue de capas para mantener la seguridad (CRN-01) en el sistema y agrupar los submódulos en la capa de lógica de negocio (CRN-03). |
| DEC-02 | Para desplegar los servicios de mensajería por correo se utilizará el servicio de SES que será llamado por medio de una función Lambda. | Esto asegura la seguridad (CRN-01), rendimiento y escalabilidad (CRN-02)                                                  |
| DEC-03 | La data almacenada en la base de datos estará siempre encriptada                                                               | Crucial para almacenar los datos de forma segura. Con esto se cumplen las restricciones de tecnología (CRN-04) y seguridad (CON-05) |

## Diagrama de capas

![capas](/proyecto/images/ADD/Iteracion1/capas.png)

[Volver al inicio](../ADD.md)