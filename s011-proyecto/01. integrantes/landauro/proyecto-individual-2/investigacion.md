# 6.2 Desarrollo Conceptual

## Arquitectura de aplicaciones móviles

> En la última década, el uso de dispositivos móviles ha crecido exponencialmente, transformándose en una parte integral de la vida cotidiana de millones de personas en todo el mundo. Según estadísticas recientes, el número de usuarios de teléfonos inteligentes supera el 75% a nivel global (https://news.un.org/es/story/2023/12/1526712), y se espera que esta cifra continúe aumentando en los próximos años. Este crecimiento ha impulsado una demanda sin precedentes de aplicaciones móviles, que han evolucionado desde simples utilidades hasta sofisticadas herramientas que abarcan diversos aspectos de la vida diaria, incluyendo comunicación, entretenimiento, salud, finanzas, y educación.

> En este contexto, la elección de la tecnología y la arquitectura para el desarrollo de aplicaciones móviles se ha convertido en una decisión estratégica crítica para las empresas y desarrolladores. Las aplicaciones móviles pueden desarrollarse utilizando diferentes enfoques: nativas, híbridas y multiplataforma. Cada uno de estos enfoques ofrece sus propias ventajas y desventajas, que pueden influir significativamente en el rendimiento de la aplicación, la experiencia del usuario, el tiempo de desarrollo y los costos asociados.

> El objetivo principal de esta investigación es proporcionar una evaluación y comparación de las aplicaciones nativas, híbridas y multiplataforma, desarrolladas exclusivamente para los dos sistemas operativos más utilizados a nivel mundial, iOS y Android, con el fin de guiar a los desarrolladores y empresas en la toma de decisiones informadas sobre la elección de la tecnología de desarrollo móvil.

### Arquitecturas Nativas

#### Frameworks

> - iOS: SwiftUI
> - Android: Kotlin

#### Ventajas (https://bambu-mobile.com/ventajas-y-desventajas-de-las-apps-nativas/)

> Gran Rendimiento:
> - Son más veloces porque en los dispositivos se guardan todos los componentes (visuales y de contenido), lo que hace que la carga sea más rápida.
> - Tienen mayor soporte en cuestión de software.

> Mejor Experiencia de Usuario:
> - Las apps nativas acceden a las API’s y componentes únicos del sistema operativo, proporcionando una experiencia más fluida y coherente.

> Gran Nivel de Personalización:
> - Debido a que el programa se desarrolla de manera específica para cada plataforma, el nivel de optimización y personalización es mayor.
> - Se entrega una app completa y compleja con funcionalidades adaptadas al sistema operativo.

> Reducción de Errores:
> - En comparación con las apps híbridas, las fallas se reducen, pues el proyecto se adapta específicamente al sistema operativo.

> Seguridad:
> - A diferencia de los desarrollos híbridos, estas aplicaciones están protegidas por varias capas de seguridad, proporcionando un mayor nivel de protección de datos.

> Actualización Instantánea:
> - Tanto las aplicaciones como los sistemas operativos ejecutan las nuevas funciones cada vez que hay una actualización.

> Disponibilidad en las Tiendas:
> - Las apps deben pasar por un examen de calidad para que las tiendas de aplicaciones (stores) las publiquen, asegurando un nivel mínimo de calidad.

> Estabilidad:
> - Los exámenes de calidad de las tiendas buscan que los software cumplan con los términos de uso, mantenimiento y desarrollo, lo que mejora la estabilidad de la aplicación.

#### Desventajas (https://bambu-mobile.com/ventajas-y-desventajas-de-las-apps-nativas/)

> Mayor Costo:
> - Gestionar estas aplicaciones es más costoso desde la inversión inicial hasta la conclusión del proyecto.
> - Este gasto se incrementa si se desea trabajar el programa para diversos sistemas operativos al mismo tiempo.

> Más Tiempo para Desarrollar:
> - Además del costo, las apps nativas implican un mayor periodo en la creación.
> - En el caso de querer hacer el mismo programa para diferentes sistemas, se recomienda realizarlo en paralelo, lo cual puede duplicar el tiempo necesario.

> Código Único:
> - Los códigos creados no pueden usarse en el diseño de otra aplicación porque solo sirven para un sistema operativo particular.

> Equipo Especializado:
> - Si el equipo desarrollador no cuenta con el personal adecuado para desarrollos nativos, se debe buscar a las personas con las habilidades y capacidades necesarias para apoyar en el proyecto.
> - Esto significa una mayor inversión en la contratación y formación del equipo especializado.

### Arquitecturas Híbridas

#### Frameworks

> - Ionic

#### Ventajas (https://bambu-mobile.com/ventajas-y-desventajas-de-las-apps-hibridas/)

> Costo:
> - Ya que se mantiene una base de código única para varios sistemas operativos, es menor el costo para desarrollar.
> - Tiempo de Desarrollo:
> - Ya que solo se escribe el código una vez, el tiempo de desarrollo es más rápido en comparación a las aplicaciones nativas. Este tipo de proyectos tarda semanas en lugar de meses. Además, es más breve enviarlo al control de calidad.

> Mantenimiento:
> - Muchos de los proyectos híbridos están escritos en lenguaje HTML simple, lo que hace más fácil sustentarlo.
> - El mantenimiento se le da a todos los sistemas operativos con una base única de código.

> Escalabilidad:
> - Son mucho más escalables en las plataformas, por lo que no se tiene que escribir la aplicación de nuevo, sino introducir los cambios.

> Actualizaciones:
> - Se lanzan actualizaciones constantes para corregir bugs y otros errores que surjan. Estas no necesitan de la aprobación de la store y los cambios se muestran de manera inmediata.

> Acceso Inmediato:
> - Estas aplicaciones pueden descargarse a través de enlaces, páginas web y la store, lo cual brinda un mayor número de portales para bajarlas.
> - Llegar a Más Público:
> - Los desarrollos híbridos permiten captar mayor audiencia y ser instaladas por usuarios de cualquier plataforma.

> Sin Versiones:
> - Mientras una aplicación nativa saca versiones nuevas cada determinado tiempo, las apps híbridas producen una app solamente.

> Requiere de Internet:
> - Las apps híbridas pueden trabajar sin necesidad de wi-fi. Algunas almacenan los datos en servidores locales, por lo que, en caso de no tener red, es posible acceder a la información sin ningún problema.

#### Desventajas (https://bambu-mobile.com/ventajas-y-desventajas-de-las-apps-hibridas/)

> Rendimiento:
> - Es más lento debido a la capa entre el sistema operativo y el código fuente. Esto depende del tamaño de la app, pues cuando es más pequeño, no se nota.

> Experiencia de Usuario:
> - La interfaz ofrece una experiencia de usuario deficiente, ya que no puede adaptarse a todas las plataformas en su totalidad.

> Funcionalidad:
> - Algunas funciones que estarían presentes en los desarrollos nativos no son aprovechadas en los softwares híbridos, por lo que no se tiene el mismo nivel de calidad y estabilidad.

> Funcionalidades que Demoran en Aparecer:
> - Cada que los sistemas operativos integran una nueva función, las apps híbridas tardan en añadirlas.

> Gráficos:
> - Las imágenes no tienen una calidad tan buena comparada con las nativas. Y solo mejoran cuando se usan herramientas externas.

> Depuración:
> - Encontrar y limpiar un código resulta ser más difícil por la diferencia entre plataformas. En este sentido, se debe cuidar que no haya errores y hacer pruebas de forma más seguida.

> Fallas:
> - Aunque el contenido se revise, pueden existir problemas que solo se detectan cuando el software está trabajando.

### Arquitecturas Multiplataforma

#### Frameworks

> - Kotlin multiplatforms.
> - React native.
> - Flutter.

#### Ventajas (https://www.grupoebim.com/en/blog/ventajas-desventajas-flutter/)

> Respuestas Inmediatas:
> - Flutter ofrece la función de recarga en caliente, que permite actualizaciones instantáneas sin necesidad de plugins.
> - Permite ver las actualizaciones en tiempo real y solucionar errores de inmediato sin tener que reiniciar el código.
> - Mejora la productividad, permite iteraciones rápidas y experimentación sin largas demoras.

> Rendimiento Nativo:
> - Se ejecuta sobre Skia, un motor gráfico que permite un desarrollo rápido y bien optimizado.
> - Es indistinguible de las apps nativas, ya que no depende de intérpretes ni de representaciones de código intermedias.

> Reducción del Tiempo de Desarrollo:
> - Los requisitos para el desarrollo de aplicaciones Flutter son mucho menores.
> - No hay gastos de mantenimiento adicionales.
> - Permite crear apps más grandes utilizando características únicas en menos tiempo.

> Mayor Velocidad de Comercialización:
> - El marco de desarrollo Flutter es más ágil que otros.
> - El rápido time-to-market (TTM) es una de sus principales ventajas.
> - Permite el uso multiplataforma, facilitando la entrega de productos a tiempo en iOS y Android.

> Motor de Renderizado Propio:
> - A diferencia de otras soluciones multiplataforma, Flutter ofrece paquetes que contienen un conjunto de widgets únicos para ambos sistemas operativos.
> - Evita las similitudes excesivas entre las versiones de iOS y Android, proporcionando una experiencia más nativa y diferenciada.

> Aprendizaje Sencillo:
> - Aprender el lenguaje de programación Dart es sencillo.
> - Muchos desarrolladores con pocos conocimientos de codificación pueden desarrollar prototipos y aplicaciones con el framework.
> - La experiencia en el desarrollo de aplicaciones móviles no será una limitación en este proceso.

#### Desventajas (https://www.grupoebim.com/en/blog/ventajas-desventajas-flutter/)

> Aplicaciones Grandes y Pesadas:
> - Un detalle que no podemos pasar por alto es el gran tamaño de las aplicaciones en desarrollo.
> - Los desarrolladores de software que trabajan con este kit de herramientas pueden tener dificultades para manejar archivos de gran tamaño, lo que podría hacer que opten por una alternativa más ligera.

> Posibles Problemas con iOS:
> - El framework Flutter funciona bien tanto en Android como en iOS. Sin embargo, Google desarrolló este paquete de herramientas, lo que da a las aplicaciones de Android una ventaja clave y brinda una experiencia de creación más rápida y agradable.
> - En iOS, las actualizaciones pueden tardar un poco más. Aunque esto no se considera un problema importante, es algo a tener en cuenta en caso de que pueda surgir algún inconveniente en el futuro.

> Baja Popularidad de Dart:
> - Algunos desarrolladores consideran que no puede competir con otros lenguajes como C#, Java, Objective C y JavaScript por su bajo rendimiento en aplicaciones pesadas.


# 6.3 Consideraciones técnicas

Para configurar los tres ambientes para desarrollar para móviles con sistema operativo iOS, es necesario tener una computadora con MacOS y XCode.

## 6.3.1. Instalación / Configuración de servicio

Los tres escenarios serán planteados para desarrollar aplicaciones de iOS.

### Aplicaciones nativas

- Es necesario tener instalado XCode y el SDK para simular dispositivos con iOS.

### Aplicaciones híbridas

- Serán desarrolladas con la plataforma web de ionic Framework

### Aplicaciones multiplataforma

- Serán desarrolladas con Flutter

## 6.3.2. Primeros pasos

### Aplicaciones nativas

- Utilizar los tutoriales de Apple para comenzar con el desarrollo en iOS: https://developer.apple.com/tutorials/app-dev-training/

### Aplicaciones híbridas

- Utilizar la documentación de ionic Framework para comenzar a desarrollador para iOS: https://ionicframework.com/docs/

### Aplicaciones multiplataforma

- Utilizar la documentación de Flutter para comenzar a desarrollador para iOS: https://docs.flutter.dev/get-started/install


# 6.4 Demo

## 6.4.1 Escenario practico

Para los 3 escenarios prácticos, vamos a crear las aplicaciones más básicas que nos deja cada tipo de arquitectura disponible.

## 6.4.2 Pasos para la demo

Es necesario haber leido la documentación de los 3 ambientes previamente mencionados y tener las aplicaciones y sdks descargados.
https://youtu.be/BPRE7n2qRaw

## 6.4.3 Resultados

Los 3 ambientes nos ofrecen aplicaciones móviles para la plataforma de iOS, por lo que nos queda debatir sobre las capacidades que esperamos que tengan nuestras aplicaciones para elegir la arquitectura correcta.