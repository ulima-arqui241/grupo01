# Serverless: Desarrollo en la Nube sin Servidores

## Concepto

Serverless es la nueva forma de crear y ejecutar aplicaciones en la nube, donde el proveedor (como AWS, Azure o Google Cloud) se encarga de toda la infraestructura. Tú solo te centras en escribir el código, y la nube se encarga de escalar tu aplicación automáticamente según la demanda, cobrándote únicamente por el tiempo de ejecución real.

### ¿Quién ofrece Serverless?

Los grandes de la nube tienen sus propias soluciones: AWS Lambda, Azure Functions, Google Cloud Functions e IBM Cloud Functions. Pero no son los únicos, también existen Alibaba Cloud Function Compute, Cloudflare Workers y opciones de código abierto como Knative y OpenFaaS.

### Aplicaciones tecnológica

- **Aplicaciones web y móviles:** Backend ágil y escalable.
- **Procesamiento de datos en tiempo real:** Ideal para analizar datos de redes sociales o sensores.
- **Automatización de tareas:** Ejecuta tareas programadas o en respuesta a eventos sin preocuparte por servidores.
- **Internet de las Cosas (IoT):** Procesamiento de datos y comunicación entre dispositivos IoT sin complicaciones.
- **Chatbots y asistentes virtuales:** Procesamiento de lenguaje natural y generación de respuestas de forma eficiente.

## Serverless vs. lo Tradicional: ¿Cuál es la Diferencia?

| Característica         | Serverless                         | Infraestructura como Servicio (IaaS) | Plataforma como Servicio (PaaS) |
|------------------------|------------------------------------|-------------------------------------|---------------------------------|
| Gestión de servidores  | El proveedor se encarga de todo.   | Tú tienes el control total de los servidores. | El proveedor gestiona servidores y SO, tú te encargas de la aplicación. |
| Escalabilidad          | Automática y precisa según la demanda. | Escalado manual o con herramientas externas. | Escalado automático o manual, pero menos preciso que Serverless. |
| Costo                  | Pagas solo por el tiempo de ejecución real. | Pagas por los recursos reservados, aunque no los uses. | Pagas por recursos reservados y servicios adicionales. |
| Flexibilidad           | Mucha libertad para desarrollar y desplegar aplicaciones rápidamente. | Gran flexibilidad para personalizar el entorno y las configuraciones. | Menos flexible que IaaS y Serverless. |
| Complejidad            | Simplifica la operación, te centras en el código. | Mayor complejidad, ya que debes gestionar la infraestructura. | Complejidad intermedia entre IaaS y Serverless. |

## Ventajas

- **Ahorro:** No pagas por servidores que no usas.
- **Escalabilidad automática:** Tu aplicación puede crecer sin mucha manipulación.
- **Productividad:** Menos enfoque en la infraestructura y más en el desarrollo.
- **Lanzamientos rápidos:** Despliega tus aplicaciones rápidamente.
- **Menos complicaciones:**  Menor complejidad en la gestión de servidores.

## Desventajas

- **Dependencia del proveedor:** Cambiar de plataforma puede ser complicado.
- **"Arranque en frío":** Posible retraso inicial al activar funciones inactivas.
- **Límites de tiempo y memoria:** Ojo con las restricciones de recursos.
- **Depuración y monitoreo:** Algo más complejo que en entornos tradicionales.
- **Costos inesperados:** El escalado automático puede sorprenderte si no estás atento.

## Ejemplo de costeo de Serverless con AWS Lambda
AWS Lambda, el servicio serverless ofrecido por Amazon, establece su tarifa basada en dos criterios:

## Criterios de Cobro

- **Solicitudes**: Cada ejecución de tu función Lambda se cuenta como una solicitud. AWS te otorga un millón de solicitudes gratuitas cada mes y, después de eso, cada millón adicional cuesta solo $0.20.
- **Tiempo de ejecución**: El tiempo que tarda tu función en ejecutarse determina el costo, cobrando cada milisegundo y redondeando al siguiente centenar. Aumentar la memoria asignada a la función incrementa el costo por milisegundo.

## Beneficios de ahorro con AWS Lambda

- **Pago por uso**: Pagas exclusivamente cuando tus funciones están activas, eliminando los costos por recursos ociosos.
- **Escalado automático**: Lambda ajusta su capacidad automáticamente, evitando cobros excesivos durante periodos de baja demanda.
- **Sin necesidad de mantenimiento**: Te liberas de la gestión de servidores y actualizaciones, lo cual significa un ahorro de tiempo y dinero.
- **Optimización de código**: Ajustar tu código y la configuración de Lambda puede reducir aún más tus costos.

## Ejemplo práctico de costos

Considera una función Lambda que opera 5 millones de veces al mes, con una duración promedio de 200 milisegundos y un uso de 1 GB de memoria.

- **Solicitudes**: (5,000,000 - 1,000,000) * $0.20 / 1,000,000 = $0.80
- **Duración**: 5,000,000 * 0.2 segundos * $0.00001667 por GB-segundo = $16.67
- **Costo total estimado**: $0.80 + $16.67 = $17.47

## Consejos para maximizar el ahorro

- **Asignación adecuada de memoria**: Ajusta la memoria al mínimo necesario para tu función.
- **Optimización del código**: Mejora la eficiencia de tu código para que se ejecute más rápido.
- **Aprovechamiento de recursos gratuitos**: Utiliza al máximo el millón de solicitudes gratis al mes.
- **Monitoreo de costos**: Vigila tus gastos para identificar oportunidades de ahorro.

AWS Lambda ofrece una opción costeable para la computación serverless, pero los costos finales variarán según el uso y configuración de tus funciones. Es crucial entender bien la estructura de precios y seguir estos consejos para optimizar tus recursos en esta plataforma.

## Contexto del demo

## FaaS (Function as a Service)

FaaS (Function as a Service) es una forma de construir software en la nube donde cada función se ejecuta de manera independiente, sin preocuparte por los servidores ni su mantenimiento. Es como tener un equipo de expertos que se encarga de la infraestructura mientras tú te concentras en diseñar cada pieza del rompecabezas.

### Relación con Serverless

Serverless es un concepto más amplio que engloba a FaaS. Es una filosofía de desarrollo donde la gestión de servidores y la infraestructura subyacente es responsabilidad del proveedor de la nube. FaaS es una herramienta clave en el mundo serverless, especializada en ejecutar funciones individuales en respuesta a eventos específicos.

### Relación con AWS Lambda

AWS Lambda es la herramienta de Amazon para crear y ejecutar funciones FaaS. Es como un taller donde puedes escribir tu código en el lenguaje que prefieras (Node.js, Python, Java, Go, etc.) y luego activarlo con diferentes eventos, como solicitudes web, cambios en bases de datos, señales de dispositivos IoT y mucho más.

#### Resumiendo:

- **Serverless**: Es la visión de construir aplicaciones sin preocuparte por los servidores.
- **FaaS**: Es una herramienta dentro de serverless para ejecutar funciones individuales.
- **AWS Lambda**: Es el servicio de Amazon que te permite crear y ejecutar funciones FaaS de forma sencilla.


## Conclusión

Serverless es una revolución en el desarrollo de aplicaciones en la nube. Te libera de la gestión de servidores y te permite centrarte en lo que realmente importa: crear. Pero antes de dar el salto, evalúa si es la opción adecuada para tu proyecto y elige el proveedor que mejor se adapte a tus necesidades.

## Referencias

- Amazon Web Services (AWS): https://aws.amazon.com/lambda/
- Microsoft Azure: https://azure.microsoft.com/en-us/services/functions/
- Google Cloud Platform (GCP): https://cloud.google.com/functions
- Red Hat: https://www.redhat.com/es/topics/cloud-native-apps/what-is-serverless

