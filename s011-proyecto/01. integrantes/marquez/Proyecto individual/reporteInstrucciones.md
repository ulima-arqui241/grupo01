# Bases de datos NoSQL - Orientadas a documentos

## 1. Desarrollo conceptual

### ¿Qué es una base de datos NoSQL?

El termino NoSQL no tiene un significado fijo como su contraparte SQL, pero la mayoría coincide en que significa ¨Not only SQL¨ (Burd, 2011). Estas bases nacen como una alternativa a las bases de datos relacionales tradicionales (Romero et al., 2012), ya que el contexto tecnológico actual favorece la velocidad y un gran densidad de datos a almacenar. Como menciona Burd (2011), las bases de datos no relaciones son un rechazo al esquema tradicional, el cual surge a partir de 3 diferentes problemas que afrontan las empresas: un volumen sin precedentes de transacciones, una expectativa de baja latencia por parte del usuario y una alta disponibilidad, casi perfecta, del servicio. 

### Teorema CAP

Eric Brewer alrededor del año 2000 propuso un teorema sobre la bases de datos, en los cuales se debe tener un balance sobre tres aspectos fundamentales de las bases de datos, llamado teorema CAP, por s: disponibilidad (availability), consistencia (consistency) y tolerancia a particiones (partition tolerance) (como se cito en Romero et al, 2012). Este concepto es importante sobre las bases de datos NoSQL, ya que al ser uno de los pilares de estos motores la velocidad y escalabilidad, es imposible conservar los tres puntos. Esto quiere decir que uno deberá sacrificar un aspecto por mantener los otros dos. Por ello, los administradores de bases de datos y desarrolladores en general deben tener este punto en cuenta a la hora de elegir una base de datos NoSQL.

### ACID y la concurrencia de las transacciones

Al igual que CAP, ACID es otro concepto común en el mundo de las bases de datos, el cual es importante de considerar al hablar de bases NoSQL. Como mencionan Romero et al. (2012) la atomicidad de las transacciones no sigue las reglas rígidas que presenciamos en las bases relacionadas, sino que se opta por una vía "relajada". Esto quiere decir que, a fin de evitar que se violen algunos de los factores transaccionales ACID, las bases NoSQL optan por difentes métodos que no interfieren con la velocidad de las transacciones, tales como chequeos temporizados o el uso de vectores programados (Burd, 2011), o tambien sistemas de versionados, tal como se verá más adelante en la demostración. Esta consideración llevo a crear un nuevo paradigma sobre las transacciones: BASE (Basically Available, Soft State, Eventually Consistent). Este modelo asume que las transacciones pueden estar en un estado de flujo en cuanto a su consistencia se refiere, considerando que existen protecciones contra posibles fallos (Romero et al, 2012).

### Ventajas y desventajas de las bases NoSQL
Algunas de las ventajas que ofrecen las bases NoSQL son su alta escalabilidad y horizontalidad; su eficiencia a la hora de usar recursos; la velocidad de respuesta; la simpleza de sus consultas y su falta de un esquema rígido, el cual permite un rapido desarrollo y mutación del modelado de datos (Romero et al., 2012). Otro factor importante, como señala Burd (2011) es la integración con lenguajes de datos populares, tal como es Javascript. Esto favorece el desarrollo y comprensión de los datos, asi como facilita las labores del programados.

Por otro lado, las bases de datos NoSQL tambien presentan algunas desventajas. La falta de esquemas y el no cumplir con ACID en cuanto a transacciones presenta un cambio brusco de paradigmas para alguien que suele trabajar con motores de bases de datos relacionales. Asimismo, debido a la forma como las bases NoSQL administran los datos, realizar consultas complejas con muchos datos entrelazados puede ser muy costoso si es que no existen una correcta planeación desde el diseño. Este detalle nos da a entender que la administración de una base NoSQL, considerando su libertad de esquema, provoca que la calidad de los datos almacenados y su estructura recaiga sobre una mayor y adecuada abstracción de los modelos de datos realizada por los administradores de la misma. Por último, a diferencia de SQL, no existe un éstandar del lenguaje utilizado. Esto puede complicar la transferencias de conocimientos de una base no relacional a otra.

## 2. Consideraciones tecnicas

Considerando que no existe un estandar a seguir, en esta sección se detallaran aspectos importantes relacionados a las bases de datos orientadas a documentos.

### ¿Que es una base de datos orientada a documentos?

Como mencionan Burd (2011) y Romero et al. (2012), las bases de datos orientadas a documentos basan su funcionamiento alrededor del concepto del documento.

### Documentos

Un documento es una unidad de almacenamiento estructurado en formatos comunes dentro la programación, como lo son JSON, XML o YAML. Estos permiten almacenar grandes cantidades de información organizadas mediante agrupaciones de llave-valor (Romero et al, 2012).

### Colecciones

Las colecciones son agrupaciones de documentos dentro de una misma base de datos. Esto permite organizar los documentos de la misma manera que una tabla organizaría filas, pero considerando que los documentos no poseen una estructura predeterminada (Romero et al, 2012).

### Denormalización de datos

Por lo general, con las bases de datos relacionales se busca normalizar los datos para evitar redundancia. Con las bases de datos NoSQL, y enfoncándonos en las orientadas a documentos, se debe cambiar el enfoque y pensar en denormalizar (retroceder una regla normal) los datos. Consideremos el siguiente ejemplo:

![Ejemplo 1 normalizacion](/imagenes/ejemplo1.png)

En este caso seguimos una normalización común, donde cada evento tiene sus respectivos tickets y cada ticket le corresponde a un usuario. Asumamos que un cliente puede comprar múltiples tickets, en diferentes eventos. Con la modelación actual, una consulta sobre todos los tickets de un usuario se volvería muy compleja, ya que se tendría que buscar por cada evento los tickets, y luego operar sobre los resultados. Si bien una base relacional no presenta dicho problema al especializarse en este tipos de consultas multirelacionales, es posible solucionar este caso sin recurrir a un cambio de paradigma. Veamos el siguiente ejemplo:

![Ejemplo 2 normalizacion](/imagenes/ejemplo2.png)

Al trasladar los tickets a su propio arreglo o colección somos capaces de recuperar todos los tickets de un usuario, sin realizar una compleja consulta. También, se puede utilizar el identificador del documento para relacionarlo con su evento respectivo. Es notoria la redundancia, pero como se mencionó antes, es necesario cambiar el enfoque y aprovechar las características de estas bases de datos realizando una mayor abstracción, las cuales pueden escribir y recuperar datos en crudo de manera rápida y eficaz.

Cabe resaltar que la denormalización nace a partir del supuesto que el modelo de datos se encuentra normalizado o organizado a cierto nivel. Este método no es efectivo si los datos no tienen una lógica entre sí

## 3. Instrucciones de la demo

Para la demo es escogio CouchDB, la cual es una base de datos orientada a documentos que otorga una API REST mediate metodos HTTP, además de diferentes funcionalidades intersantes que veremos poco a poco. Una video de la siguiente demostracion puede ser hallada en el siguiente enlace: https://drive.google.com/file/d/1fwqtn2c0bJRrFdDiTnff7NRs-7nTp_Yr/view?usp=sharing

Para comenzar, primero debemos comprobar que tengamos docker instalado. Si poseen docker desktop o pueden ejecutar el siguiente comando:

```
docker --help
```
Significa que pueden seguir con la guía. Caso contrario, visiten https://docs.docker.com/get-docker/ y sigan la guía de instalación según su sistema operativo.

Una vez nos aseguremos de tener docker, abriremos una terminal y nos dirigiremos a la ubicación donde se encuentre esta carpeta. Una vez allí, ejecutaremos el siguiente comando:

```
docker compose up
```
El resultado deberia ser algo similar a lo siguiente

![Demo 1](/imagenes/demo1.png)

Y si revisamos docker desktop (en caso lo tengamos installado) veremos la instancia creada:

![Demo 2](/imagenes/demo2.png)

Ahora si, nos dirigimos a http://localhost:5984/_utils para continuar. Si todo funciona correctamente veremos la siguiente pantalla:

![Demo 3](/imagenes/demo3.png)

Ingresamos con el usuario admin y el password 123 (los valores pueden ser modificados en el archivo .env). Deberiamos ingresar al siguiente dashboard:

![Demo 4](/imagenes/demo4.png)

Por ahora no poseemos ninguna base de datos, pero ahora cambiaremos eso. Ahora sera necesario entrar a Postman o algun programa similar, el cual nos facilite realizar peticiones http. Para facilitar la demo, el workspace utilizado puede ser importado desde el archivo ArquiSoft.postman.json a postman u otros servicios que acepten dicho archivo. Para continuar con la demo se utilizaran las peticiones de dicho workspace, pero es posible realizar variaciones basadas en las siguientes partes. 

Lo que debe resaltarse es la autenticacion. Dado que no hemos creado mas usuarios ademas del admin, tendremos que usar las credenciales del mismo para interactuar con la base de datos. En el proyecto de Postman las credenciales ya estan configuradas, pero en caso se utilice otro servicio o programa como curl, deben agregarse las cabeceras correspondientes o modificarse en caso se desee utilizar otras credenciales.

Lo primero sera revisar la creacion de bases de datos. Nos dirigimos a la carpeta Databases dentro del proyecto de postman. Dentro de ella veremos la siguiente peticion:

![Demo 5](/imagenes/demo5.png)

Como mencionamos, CouchDB provee una API REST mediante http por la cual se pueden realizar diferentes operaciones basado en el tipo de peticion y la url. En este caso se puede leer la peticion como "coloca (PUT) una base de datos llamada matches en el localhost:5984". Al realizar la peticion obtendremos la siguiente respuesta:

![Demo 6](/imagenes/demo6.png)

Esto nos quiere decir que la creacion fue exitosa, devolviendo un codigo 201, mencionando la creacion. Si revisamos nuestro cliente en http://localhost:5984/_utils veremos que se ha creado la nueva base de datos

![Demo 7](/imagenes/demo7.png)

De la misma manera, podemos eliminar la base de datos recien creada, simplemente cambiando el tipo de peticion a DELETE, como se muestra en la imagen:

![Demo 8](/imagenes/demo8.png)

Y la instancia de CouchDB nos responde con la correcta eliminacion de la base de datos:

![Demo 9](/imagenes/demo9.png)

![Demo 10](/imagenes/demo10.png)

Eso ha sido lo basico de la creacion de bases de datos. Ahora veremos algunas operaciones CRUD. Primero volvamos a crear la base de datos matches. Posteriormente, nos dirigiremos a la carpeta de Documents, y luego a la peticion de createDocument. Al entrar veremos lo siguiente:

![Demo 11](/imagenes/demo11.png)

La primera diferencia que observamos es que la url se ha extendendido. Los digitos posteriores al nombre de la base de datos corresponden a nuestro identificador de documento. En este caso ese valor es "0000000001". Puede ser reemplazado por lo que deseen, solo deben considerarlo en las siguientes partes.

La siguiente diferencia es la inclusion de un cuerpo en la peticion. CouchDB trabaja con JSON como formato para codificar/decodificar la informacion. En este caso hemos agregado informacion basica sobre un partido. Al enviar la peticion recibiremos el siguiente mensaje:

![Demo 12](/imagenes/demo12.png)

El cual nos devuelve un mensaje de confirmacion, la id del documento y su numero de revision. Este es importante, ya que es una de las maneras por la cual CouchDB administra la integridad de sus datos. Por ahora dejemoslo ahi y revisemos el documento en el portal web:

![alt text](/imagenes/image.png)

El documento fue creado exitosamente. Siguiendo las operaciones, lo siguiente seria leer los documentos. Para ello, utilizaremos un metodo get, como el que encontramos en getDocument. Si nos damos cuenta, la url no ha cambiado, pero si el tipo de peticion a un tipo get. Al ejecutar, la respuesta nos devolvera la informacion del documento al que corresponde la id de la url, si existiese:

![alt text](/imagenes/image-1.png)

Como vemos, recibimpos la informacion del documento, ademas de su numero de revision y su id. 

El siguiente paso debe ser actualizar el documento. Hagamos que el deporte cambie a "Football". Para ello, nos dirigimos a la peticion updateDocument. En ella, se observa que es identica a la peticion para crear un documento, solo que lleva la informacion modificada en el cuerpo. Si realizamos la peticion obtendremos el siguiente error:

![alt text](/imagenes/image-2.png)

CouchDB nos menciona un conflicto de documentos. Aqui es donde entra en juego el numero de revision que vimos en las peticiones pasadas. Si agregamos a la raiz del cuerpo del JSON de la peticion dicho valor de la siguiente manera el documento se actualizara correctamente:

![alt text](/imagenes/image-3.png)

![alt text](/imagenes/image-4.png)

La respuesta nos devuelve una validacion y el nuevo valor de revision. De esta manera CouchDB asegura la integridad de sus documentos, y se defiende de posibles conflictos que puedan ocurrir frente a dos actualizaciones de usuarios al mismo tiempo.

Para finalizar con las operaciones basicas, procederemos a eliminar un documento. El numero de revision es importante, por lo que deberian copiarlo al portapapeles antes de dirigirnos a la siguient peticion.

Una vez conservado el numero de revision, nos dirigimos a la peticion de eraseDocument. Esta es de tipo DELETE y recibe un query param, haciendo referencia al numero de revision que guardamos previamente.

![alt text](/imagenes/image-5.png)

Al enviar la peticion, recibiremos la siguiente respuesta:

![alt text](/imagenes/image-6.png)

Si observamos, el documento fue eliminado, ya no se encuentra en la base de datos; pero aun asi recibimos un numero de revision. Esto sirve para temas de auditoria e integridad de datos. Por ejemplo, si realizamos una consulta hacia la informacion de nuestro documento recien eliminado, observaremos un mensaje diferente a el de un documento que nunca fue creado:

![alt text](/imagenes/image-7.png)


Como se observa, la base de datos sabe que el documento fue eliminado, y tiene un registro de dicha operacion gracias al numero de revision.

Como ultima demostracion, se hablara de las vistas. Las vistas son consultas pre-escritas en javascript la cual nos permite visualizar la informacion de una base de datos filtrada u ordenada de la manera que determinemos. Para este ejemplo, crearemos 4 documentos siguiendo la estructura previa de partidos, solo cambiando el deporte entre Futbol y Basketbol. 

![alt text](/imagenes/image-8.png)

![alt text](/imagenes/image-9.png)

![alt text](/imagenes/image-10.png)

![alt text](/imagenes/image-11.png)

Ahora pongamonos en la situacion que un usuario solo desea ver los partidos de futbol. Una solucion no ideal seria realizar el filtrado en el cliente. Otra podria ser realizar una API entre la base de datos y el cliente que filtre los datos. Pero con las vistas podemos realizar ese tipo de consultas de manera sencilla utilizando un lenguaje conocido como Javascript. Para comenzar entremos a nuestra base de datos matches desde el portal web. Ahi le daremos a "Design documents" en el lateral izquierdo de la pantalla, y luego a "new View". La pantalla deberia llevarles a un formulario como el siguiente: 

![alt text](/imagenes/image-12.png)

En el podremos crear tanto un documento de diseño (el cual almacena las vista) asi como una nueva vista. Por ahora llamemos al documento showSport y a la vista showFutbolMatches. Posteriormente, peguemos el siguiente codigo en la funcion map:

```
function (doc) {
  if (doc.sport === "Futbol") {
    emit(doc._id, doc)
  }
}
```

Este codigo lo que esta recibiendo son los documentos como parametros, y, siguiendo la logica de javascript, le estamos diciendo que si su valor "sport" es igual a "Futbol", que emita ese documento, usando su id como llave y el documento en si como valor. El formulario final deberia verse de la siguiente manera:

![alt text](/imagenes/image-13.png)

Le damos al boton verde para crear el documento y la vista en la base de datos. Para comprobar su funcionamiento, volvemos a postman. Una vez ahi, en al carpeta Views veremos una peticion de tipo GET llamada showFutbolMatches. Al entrar veremos la siguiente url

![alt text](/imagenes/image-14.png)

Lo que esta url nos quiere decir es que se realiza una consulta a la base de datos matches, a su documento de diseño showSports y a su vista showFutbolMatches. Si en algun momento se cambiaron los nombres del documento de diseño o la vista la url debe ser actualizada. Al realizar la peticion observamos que la respuesta contiene mucha informacion, entre ella, los dos documentos que creamos con el valor de "Futbol".

![alt text](/imagenes/image-15.png)

Ese es el poder de las vistas. Estas nos permiten extraer logica que aplicariamos en un client o middleware para ejecutarla de manera eficaz y eficiente antes de resolver una consulta.

Hasta aqui llega la demo. Por favor revisen la documentacion de CouchDB en https://docs.couchdb.org/en/stable/ y miren mas funcionalidades que posee CouchDB o la extension de las presentadas en esta demo. Gracias por su atencion


# Referencias

Romero, A. C., Sanabria, J. S. G., & Cuervo, M. C. (2012). Utilidad y funcionamiento de las bases de datos NoSQL. Facultad de Ingeniería, 21(33), 21-32.

Burd, G. (2011). What Is NoSQL?. http://nosql-database.org.