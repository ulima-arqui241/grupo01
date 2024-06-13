## Introducción

Una aplicación puede comenzar enfocándose en una interfaz web de escritorio, desarrollando un backend que soporte sus funciones. Con el tiempo, al crecer la base de usuarios, se crea una aplicación móvil que debe interactuar con el mismo backend. Esto convierte al backend en un servicio de propósito general que debe servir tanto a la interfaz de escritorio como a la móvil. Sin embargo, dadas las diferencias de cada dispositivo, los requerimientos pueden verse alterados. Para cubrir esta problemática, Newman (2015) desarrollo el patrón Backend For Frontend (BFF). Este implica diseñar un backend distinto para cada tipo de experiencia de usuario, en lugar de emplear un único backend general que soporte todas las interfaces. Cada debe contar con su propio back, adaptado para satisfacer los requerimientos específicos.

Este patrón puede ser utilizado cuando se necesita proporcionar funcionalidad específica para una interfaz móvil o de terceros, sería muy recomendable usar un BFF para cada uno desde el principio. Podría reconsiderar esta opción si el costo de desplegar servicios adicionales es alto, pero la separación de responsabilidades que aporta un BFF lo hace una opción atractiva en la mayoría de los casos. La idea de usar este patrón es aún más convincente si existe una separación significativa entre los equipos que construyen la UI y los servicios subyacentes, debido a los beneficios ya mencionados.

## Problemas y Consideraciones

- Problemas y Consideraciones

- Si diferentes interfaces harán las mismas solicitudes, considerar si solo backend será suficiente.

- La duplicación de código entre servicios es muy común en este patrón.

- Los servicios de backend centrados en frontend solo deben contener lógica y comportamiento específicos del cliente. 

- Se debe tomar en consideración cuánto tiempo llevará implementar este patrón.