# **Tópicos en Arquitectura de Software**

## 1. Tema
Para el siguiente componente individual del trabajo, se abordará el tema de Análisis Estático de Código, que pertenece a la categoría de desarrollo de aplicaciones.

## 2. Desarrollo Conceptual
Según Stefanović (2020), la calidad del código fuente es un pilar fundamental en el desarrollo de software, pero históricamente los desarrolladores han carecido de métodos robustos para evaluarla objetivamente. Aunque los compiladores detectan algunos errores, no garantizan la calidad general del código ni previenen fallas futuras. El análisis estático surge como una solución a este desafío. Originado en la década de 1960 para optimizar compiladores, su aplicación se ha expandido a la depuración y el desarrollo de software en general. Hoy en día, existen numerosas herramientas, muchas de ellas de código abierto, que analizan diversos lenguajes de programación y generan informes detallados sobre la calidad del código. Estas herramientas actúan como un radar, detectando desviaciones de los estándares de calidad establecidos. Sin embargo, no intervienen directamente en el código; la responsabilidad de implementar las mejoras recae en los desarrolladores.

Para expandir sobre este, según Novak (2010), Las herramientas de análisis estático de código actúan como escáneres inteligentes, buscando patrones o reglas predefinidos en el código fuente, similares a cómo un antivirus detecta amenazas. Aunque algunas herramientas permiten personalizar estas reglas, solo identificarán problemas que coincidan con los patrones establecidos. Estas herramientas son especialmente hábiles para detectar errores comunes de programación, como problemas de sintaxis, variables no declaradas o sin inicializar, violaciones de estándares de código y vulnerabilidades de seguridad. Sin embargo, su alcance es limitado y no pueden detectar errores de diseño, arquitectura o problemas relacionados con la seguridad, como el uso de bibliotecas criptográficas deficientes o contraseñas incrustadas en el código. Es importante tener en cuenta que estas herramientas, aunque valiosas, no son infalibles. Pueden generar "falsos positivos", es decir, advertencias sobre errores que en realidad no existen. Aunque este problema es más común en herramientas antiguas o menos sofisticadas, incluso las más modernas pueden tener dificultades para interpretar correctamente el código en ciertas situaciones.

- **Estático vs Dinámico**

Según Ernst (2003), el análisis estático y dinámico son dos enfoques complementarios para entender el comportamiento del software, como si se tratase de dos lentes diferentes para examinar un mismo objeto. El análisis estático, similar a un examen minucioso de planos y documentos, predice cómo podría funcionar el software en diversas situaciones sin ejecutarlo. Por otro lado, el análisis dinámico, como observar el software en acción, registra su comportamiento real bajo condiciones específicas, como una prueba en vivo. 

El análisis estático es como un estudio exhaustivo de todas las rutas posibles en un mapa, ofreciendo una visión completa de los posibles comportamientos del software en cualquier escenario. Sin embargo, esta exhaustividad puede llevar a conclusiones generales que no siempre reflejan con precisión cómo se comportará el software en una situación particular.

El análisis dinámico, en cambio, es como observar al software en su hábitat natural, revelando su comportamiento real bajo un conjunto específico de condiciones.  Proporciona información precisa sobre cómo el software interactúa con su entorno y con las entradas que recibe, aunque sus resultados pueden no ser aplicables a todas las situaciones posibles.

Ambos enfoques son valiosos y se complementan entre sí. El análisis estático es ideal para obtener una visión global de los posibles comportamientos del software, mientras que el análisis dinámico es fundamental para entender cómo se comporta en la práctica. La elección de uno u otro dependerá de los objetivos específicos del análisis, y en muchos casos, la combinación de ambos enfoques proporcionará la comprensión más completa del software.

- **Tipos de análisis estático**

Según Zhioua (2014) existen los distintos tipos de aplicaciones de análisis estático:

1. Model Checking (Verificación de Modelos):

- Automatiza la verificación de propiedades en sistemas con un número finito de estados.
- Transforma el sistema en un modelo formal para su análisis.
- Utiliza lógica temporal para especificar y verificar las propiedades deseadas.

2. Control-Flow Analysis (Análisis de Flujo de Control):

- Técnica común en análisis estático de código.
- Modela el flujo de control como un grafo dirigido (CFG) para visualizar la ejecución del programa.
- Determina cómo se llaman los procedimientos y qué funciones son ejecutadas.

3. Data-Flow Analysis (Análisis de Flujo de Datos):

- Se enfoca en los posibles valores de los datos durante la ejecución del programa.
- Representa dependencias de datos y rastrea el impacto de las entradas en el programa.
- Predice el comportamiento dinámico del programa a partir de su código estático.

4. Symbolic Analysis (Análisis Simbólico):

- Trata las variables del programa como expresiones simbólicas.
- Utiliza sistemas de álgebra computacional para simplificar y analizar estas expresiones.
- Transforma bucles complejos en secuencias predecibles para facilitar el análisis.
- Principalmente utilizado para la optimización de código en compiladores.

5. Information-Flow Analysis (Análisis de Flujo de Información):

- Aunque se suele hacer dinámicamente, el análisis estático puede aproximar los flujos de información.
- Se enfoca en cómo la información fluye dentro del programa, distinguiendo entre flujos directos e indirectos.
- Útil para analizar la seguridad de la información en el código

Según Dewhurst existen dos tipos más, los cuales son: 

6. Análisis de Taints (Análisis de Contaminación):

- Esta técnica se enfoca en identificar variables que han sido "infectadas" con datos proporcionados por el usuario y rastrea su recorrido a través del código hasta posibles puntos vulnerables. Si una variable "contaminada" llega a una función vulnerable sin antes ser desinfectada, se considera una vulnerabilidad potencial. Algunos lenguajes como Perl y Ruby tienen mecanismos de análisis de taints integrados, especialmente útiles en contextos donde se reciben datos externos (como CGI).

7. Análisis Léxico (Tokenización):

- El análisis léxico es como descomponer un texto en palabras individuales. En el caso del código fuente, lo divide en unidades más pequeñas llamadas "tokens", facilitando su manipulación y análisis.

## 3. Consideraciones Técnicas

Según Dewhurst (2024) las consideraciones que se deben tener en el análisis estático de código son: 
Lenguaje de Programación: La herramienta debe ser compatible con el lenguaje utilizado en el proyecto.

Tipos de Vulnerabilidades: Debe detectar un amplio espectro de vulnerabilidades, no solo las más comunes.

Requisitos de Código: Algunas herramientas necesitan un código fuente compilable, mientras que otras funcionan con binarios.

Integración con el IDE: La facilidad de integración con el entorno de desarrollo mejora la experiencia del usuario.

Costo de la Licencia: Los costos pueden variar considerablemente según el modelo de licencia y el proveedor.

Soporte para OOP: Es crucial si el proyecto utiliza programación orientada a objetos.

## 4. Demo
- Video del demo:
https://youtu.be/-1G8sTwi4tc

- Recursos del demo en python:
https://replit.com/@Peruh/SISSEG-SHA256

- Recursos del demo en Kotlin (SonarQube):
https://www.sonarsource.com/products/sonarqube/

- Recursos del demo en Kotlin (SonarLint):
- Puede descargarse como plugin en la configuración de Android Studio

- Recursos del demo en Kotlin (CodeMR):
https://www.codemr.co.uk/downloads/
- Puede descargarse como plugin en la configuración de Android Studio


## 5. Referencias
- Stefanović, D., Nikolić, D., Dakić, D., Spasojević, I., & Ristić, S. (2020, August). Static code analysis tools: A systematic literature review. In Ann. DAAAM Proc. Int. DAAAM Symp (Vol. 31, No. 1, pp. 565-573).
- Novak, J., & Krajnc, A. (2010, May). Taxonomy of static code analysis tools. In The 33rd international convention MIPRO (pp. 418-422). IEEE.
- Ernst, M. D. (2003, May). Static and dynamic analysis: Synergy and duality. In WODA 2003: ICSE Workshop on Dynamic Analysis (pp. 24-27).
- Zhioua, Z., Short, S., & Roudier, Y. (2014, July). Static code analysis for software security verification: Problems and approaches. In 2014 IEEE 38th International Computer Software and Applications Conference Workshops (pp. 102-109). IEEE.
- Dewhurst,Ryan(2024) Static Code Analysis. https://owasp.org/www-community/controls/Static_Code_Analysis



**Link del ppt**
https://docs.google.com/presentation/d/1kXi_okwHFjySGH1SbpnscXRd4cgFe9WulXhay_ZEv-4/edit?usp=sharing
