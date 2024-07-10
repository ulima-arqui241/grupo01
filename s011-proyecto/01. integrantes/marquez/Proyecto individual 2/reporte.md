# Pruebas de estres

Las pruebas de estrés en el software son un tipo de prueba de rendimiento que evalúa la estabilidad y el comportamiento del sistema bajo condiciones extremas de carga. El propósito principal de estas pruebas es determinar los límites y el punto de quiebre del software, identificando cómo responde cuando se incrementa la carga más allá de lo normal o esperado.

Durante las pruebas de estrés, se simulan diversos escenarios para llevar el software más allá de sus límites operativos normales. Esto incluye probar el tiempo de respuesta del sistema, el uso de memoria, el rendimiento y la estabilidad general. Al sobrecargar intencionalmente el sistema, los probadores pueden identificar cuellos de botella, pérdidas de memoria, degradación del rendimiento y posibles caídas que pueden ocurrir bajo condiciones estresantes. 

Los conocimientos obtenidos de las pruebas de estrés permiten a los desarrolladores de software tomar decisiones informadas sobre la optimización del rendimiento, la planificación de capacidad y la asignación de recursos. Esto les ayuda a identificar áreas de mejora, corregir vulnerabilidades y mejorar la experiencia general del usuario. En última instancia, las pruebas de estrés desempeñan un papel vital en asegurar que los sistemas de software puedan manejar las demandas del uso real, entregando aplicaciones confiables y de alto rendimiento a los usuarios finales.

## Objetivos

- Revisar el comportamiento del sistema bajo condiciones extremas
- Identificar los limites del sistema o software
- Verificar la efectividad del manejo de errores
- Asegurar la recuperabilidad y escalabilidad
- Encontrar cuellos de botella y mejorar el rendimiento

## Métricas

- Throughput: Ritmo por el cual el sistema puede atender transaccion a lo largo del tiempo
- Tiempo de respuesta: Tiempo que toma el sistema en responder una peticion del usuario
- Tasa de error: Porcentaje de solicitudes que no pudieron ser resueltas
- Uso de recursos: Mide el uso de los recursos fisicos (memoria, CPU, etc.)

## Flujo comun de una prueba de estres

1. Identificar puntos criticos del sistema que puedan llevar a fallos o presentar situaciones que causen estos. Por ejemplo, funcionalidades con multiples usuarios, un punto de carga especifico, un recurso comun, etc.
2. Crear casos de prueba, definiendo el comportamiento esperado, las entradas y criterios de exito y fracaso
3. Prepar un entorno de pruebas que simule el entorno en el mundo real o el producto que se le otorga al usuario final, para realizar las pruebas sin afectar a los usuarios
4. Realizar las pruebas aumentando la carga progresivamente, hasta alcanzar los limites del sujeto de pruebas
5. Analizar los resultados, enlistando cuellos de botellas, flujo de niveles de rendimiento y otros posibles resultados obtenidos
6. Plantear y aplicar mejoras basado en los resultados obtenidos. Aplicar las pruebas nuevamente para comprobar si los cambios son efectivos
7. Documentar los casos de prueba, entradas y resultados obtenidos, de manera que otros programadores o gente relacionada al proyecto conozca el proceso y comprenda los limites obtenidos

## Herramientas mas conocidas

Dependiendo de los requerimientos, el rubro del producto y otras condicionantes la eleccion de una herramienta u otra para realizar las pruebas de estres variara entre caso y caso. Por ello es bueno conocer que herramientas existen en el mercado, siendo algunas de estas:

- JMeter
- 

## Referencias

1. https://www.zaptest.com/stress-testing-in-software-testing-what-is-it-types-processes-approaches-tools-more
2. https://medium.com/@case_lab/stress-testing-for-resilient-software-dd932f4bccf2