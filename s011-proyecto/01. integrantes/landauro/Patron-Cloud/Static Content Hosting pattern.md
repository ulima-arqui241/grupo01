# Informe sobre el Patrón de Static Content Hosting

## Introducción

> El patrón de Alojamiento de Contenido Estático es una práctica utilizada para desplegar contenido estático en un servicio de almacenamiento en la nube que puede entregarlo directamente al cliente. Este enfoque puede reducir la necesidad de instancias de cómputo potencialmente costosas y optimizar la eficiencia de las aplicaciones web.

## Contexto y Problema

> Las aplicaciones web generalmente incluyen algunos elementos de contenido estático, como páginas HTML, imágenes y documentos. Aunque los servidores web están optimizados para el renderizado dinámico y la caché de salida, manejar solicitudes para descargar contenido estático consume ciclos de procesamiento que podrían utilizarse mejor.

## Solución

> En la mayoría de los entornos de alojamiento en la nube, se pueden almacenar algunos recursos y páginas estáticas de una aplicación en un servicio de almacenamiento. Este servicio puede atender las solicitudes de estos recursos, reduciendo la carga sobre los recursos de cómputo que manejan otras solicitudes web. El costo del almacenamiento en la nube suele ser mucho menor que el de las instancias de cómputo. Al alojar algunas partes de una aplicación en un servicio de almacenamiento, las principales consideraciones están relacionadas con el despliegue de la aplicación y la seguridad de los recursos que no deben estar disponibles para usuarios anónimos.

## Problemas y Consideraciones

> Para implementar el patrón de Alojamiento de Contenido Estático, se deben considerar los siguientes puntos:

> 1.	Exposición de Endpoint HTTP: El servicio de almacenamiento debe exponer un endpoint HTTP que los usuarios puedan acceder para descargar los recursos estáticos. Algunos servicios también soportan HTTPS.
> 2.	Rendimiento y Disponibilidad Máximos: Para maximizar el rendimiento y la disponibilidad, se puede usar una red de entrega de contenido (CDN) para cachear el contenido del almacenamiento en múltiples centros de datos alrededor del mundo.
> 3.	Geo-replicación: Las cuentas de almacenamiento suelen estar geo-replicadas por defecto para proporcionar resiliencia contra eventos que puedan afectar un centro de datos.
> 4.	Despliegue y Actualización: Desplegar y actualizar contenido estático y dinámico puede ser más desafiante, requiriendo despliegues separados y versionamiento adecuado.
> 5.	Nombres de Dominio Personalizados: Los servicios de almacenamiento pueden no soportar nombres de dominio personalizados, lo que requiere especificar la URL completa de los recursos.
> 6.	Configuración de Acceso Público: Es crucial configurar los contenedores de almacenamiento para acceso de lectura público, asegurando que no haya acceso de escritura público.
> 7.	Clave Valet o Token: Usar claves valet o tokens para controlar el acceso a recursos que no deben estar disponibles anónimamente.

## Cuándo Usar Este Patrón

> Este patrón es útil para:

> - Minimizar el costo de alojamiento para sitios web y aplicaciones con recursos estáticos.
> - Minimizar el costo de alojamiento para sitios web que consisten solo en contenido estático.
> - Exponer recursos estáticos para aplicaciones en otros entornos de alojamiento o servidores on-premises.
> - Ubicar contenido en múltiples áreas geográficas usando una red de entrega de contenido.
> - Monitorear costos y uso de ancho de banda al separar los costos de contenido estático de los de alojamiento y tiempo de ejecución.

## Cuándo No Usar Este Patrón

> Este patrón podría no ser útil en las siguientes situaciones:

> - La aplicación necesita realizar algún procesamiento en el contenido estático antes de entregarlo al cliente.
> - El volumen de contenido estático es muy pequeño y la sobrecarga de recuperar este contenido de un almacenamiento separado supera el beneficio de costo.

## Aprendizajes Clave

> 1.	Ahorro de Costos: El uso de servicios de almacenamiento en la nube para contenido estático es más económico que las instancias de cómputo.
> 2.	Optimización del Rendimiento: Descentralizar la carga del contenido estático a servicios de almacenamiento mejora la eficiencia de la aplicación.
> 3.	Uso de CDNs: Mejorar la disponibilidad y el rendimiento usando redes de entrega de contenido.
> 4.	Consideraciones de Seguridad: Es crucial configurar correctamente los permisos de acceso para proteger el contenido.
> 5.	Despliegue y Mantenimiento: Desplegar y actualizar contenido estático puede requerir estrategias adicionales de gestión y versionado.
> 6.	Evaluación Contextual: No siempre es beneficioso separar contenido estático, especialmente en casos de volúmenes muy pequeños o necesidades de procesamiento adicional.

## Conclusión

> El patrón de Alojamiento de Contenido Estático es una estrategia eficaz para optimizar costos y rendimiento en aplicaciones web. Al separar el contenido estático del dinámico y utilizar servicios de almacenamiento en la nube y CDNs, se puede mejorar significativamente la eficiencia y reducir los costos operativos. Sin embargo, es esencial considerar cuidadosamente las necesidades específicas de la aplicación y los posibles desafíos asociados con la implementación de este patrón.

## Fuentes:

> https://learn.microsoft.com/en-us/azure/architecture/patterns/static-content-hosting
> https://www.redhat.com/architect/pros-and-cons-static-content-hosting-architecture-pattern