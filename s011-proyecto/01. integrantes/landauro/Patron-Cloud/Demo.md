https://marcolandauro.site

### Demo basada en [AWS Labs](https://www.youtube.com/@awslabs463)
### [Link del video](https://www.youtube.com/watch?v=L6H-mJI_Izg)

# Servicios de AWS a utilizar en el laboratorio:

## Categoría 1: Storage

1. [Amazon Simple Storage Service (Amazon S3)](https://aws.amazon.com/s3/)
> - Amazon S3 is an object storage service that offers industry-leading scalability, data availability, security, and performance
> - Every object in S3 is stored in a bucket. To upload files and folders to S3, you’ll need to create a bucket where the objects will be stored.
> - With S3, there are no minimum fees. You only pay for what you use. Prices are based on the [location of your S3 bucket](https://aws.amazon.com/s3/pricing/?nc=sn&loc=4).

## Categoría 2: Networking & Content Delivery

2. [Amazon Route 53](https://aws.amazon.com/route53/)
> - Amazon Route 53 is a highly available and scalable cloud Domain Name System (DNS) web service.
> - Get started by registering a domain, configuring DNS, or using another Route 53 feature.
> - Route 53 connects user requests to internet applications running on AWS or on-premises.

3. [Amazon CloudFront](https://aws.amazon.com/cloudfront/)
> Amazon CloudFront is a fast content delivery network (CDN) service that securely delivers data, videos, applications, and APIs to customers globally with low latency and high transfer speeds.
> Enable accelerated, reliable and secure content delivery for Amazon S3 buckets, Application Load Balancers, Amazon API Gateway APIs, and more in 5 minutes or less.
> Improve security with traffic encryption and access controls, and use AWS Shield Standard to defend against DDoS attacks at no additional charge.

## Categoría 3: Security, Identity, & Compliance

4. [AWS Certificate Manager (ACM)](https://aws.amazon.com/certificate-manager/)
> Easily provision, manage, deploy, and renew SSL/TLS certificates
> Request a public certificate from Amazon or a private certificate from your organization's certificate authority (CA).
> Protect and secure your website.

# Dudas sobre los servicios de AWS utilizados para esta implementación:

## Pregunta 1:

¿Es recomendable implementar el servicio de AWS Certificate Manager en una página web estática? ¿Cuáles son las utilidades y beneficios de hacerlo, y en qué casos podría no ser tan aprovechable?

### Respuesta 1

> Implementar el servicio de AWS Certificate Manager (ACM) en una static website puede ofrecer varias utilidades y beneficios, aunque también hay aspectos que podrían no ser tan aprovechados dependiendo del caso específico. Aquí hay un desglose de las utilidades y limitaciones:

Utilidades de Implementar AWS Certificate Manager en una Static Website

> 1. Seguridad HTTPS: Proporciona certificados SSL/TLS que permiten a tu sitio web estático utilizar HTTPS. Esto asegura que la comunicación entre el cliente y el servidor sea encriptada, protegiendo la integridad y confidencialidad de los datos transmitidos.
> 2. Confianza del Usuario: Los navegadores modernos muestran advertencias cuando los sitios no utilizan HTTPS. Tener un certificado válido mejora la confianza del usuario y la percepción de la seguridad de tu sitio.
> 3. Mejor SEO: Los motores de búsqueda, como Google, favorecen los sitios web seguros (HTTPS) en sus rankings. Implementar ACM puede mejorar el posicionamiento SEO de tu sitio web estático.
> 4. Fácil Administración de Certificados: ACM simplifica la gestión de certificados SSL/TLS, eliminando la necesidad de procesos manuales complejos para la emisión, renovación y administración de certificados.
> 5. Integración con Otros Servicios de AWS: ACM se integra fácilmente con otros servicios de AWS, como Amazon CloudFront (para la distribución de contenido), Amazon S3 (para almacenamiento de sitios estáticos), y Elastic Load Balancing (para la distribución de tráfico).

Limitaciones y Aspectos No Aprovechados

> 1. Costo: Si bien ACM es gratuito cuando se usa con ciertos servicios de AWS, podrías incurrir en costos adicionales asociados con el uso de servicios complementarios como CloudFront o Elastic Load Balancing.
> 2. Simplicidad de la Aplicación: Para sitios web extremadamente simples y de bajo tráfico, la implementación de HTTPS podría considerarse un sobreesfuerzo en comparación con los beneficios obtenidos.
> 3. No Soluciona Problemas de Aplicación: La implementación de ACM no aborda otros aspectos de seguridad o funcionalidad de la aplicación web. Solo proporciona la capa de seguridad de la comunicación.
> 4. Renovación Automática Limitada a AWS: Los certificados proporcionados por ACM son renovados automáticamente solo cuando se utilizan con servicios de AWS compatibles. Si planeas migrar fuera de AWS, necesitarás gestionar los certificados manualmente.

Conclusión

> Setear el servicio de AWS Certificate Manager en una static website es altamente recomendable por las utilidades mencionadas, especialmente en términos de seguridad, confianza del usuario y SEO. No obstante, si el sitio es extremadamente simple o si los costos adicionales asociados con otros servicios de AWS son una preocupación, es posible que algunas de las ventajas no sean tan aprovechadas. En la mayoría de los casos, los beneficios de seguridad y administración superan estas limitaciones.

## Pregunta 2:

## Respuesta 2:

> La implementación de Amazon CloudFront en una página web estática pequeña puede tener varias utilidades y beneficios, aunque también hay casos en los que podría no ser tan aprovechable. A continuación, se detallan las ventajas y las posibles limitaciones de utilizar CloudFront en este contexto.

Utilidades y Beneficios de Implementar CloudFront en una Página Web Estática Pequeña

> 1. Distribución de Contenido Global: CloudFront es una red de entrega de contenido (CDN) que distribuye tu contenido a través de una red global de servidores. Esto reduce la latencia al servir el contenido desde el servidor más cercano al usuario.
> 2. Mejor Rendimiento: La caché en los edge locations de CloudFront mejora el tiempo de carga del sitio, proporcionando una mejor experiencia al usuario, especialmente para visitantes internacionales.
> 3. Seguridad: CloudFront ofrece características de seguridad como AWS Shield (protección DDoS) y AWS Web Application Firewall (WAF), que ayudan a proteger tu sitio contra diversas amenazas.
> 4. Escalabilidad: CloudFront maneja automáticamente los picos de tráfico, garantizando que tu sitio permanezca disponible y responda rápidamente incluso durante momentos de alta demanda.
> 5. Integración con Otros Servicios de AWS: Se integra perfectamente con otros servicios de AWS, como Amazon S3 para almacenamiento de archivos estáticos y AWS Lambda@Edge para ejecutar funciones sin servidor cerca del usuario.
> 6. Certificados SSL/TLS: CloudFront permite usar certificados SSL/TLS para asegurar el tráfico entre los usuarios y los servidores de edge, mejorando la seguridad de la comunicación.

Casos en los que CloudFront Podría No Ser Tan Aprovechable

> 1. Costo: Para sitios web pequeños con bajo tráfico, los costos adicionales de CloudFront pueden no justificarse frente a los beneficios obtenidos. Si tu presupuesto es limitado, es importante evaluar si el costo vale la pena.
> 2. Simplicidad del Sitio: Si tu sitio es extremadamente simple y sirve a una audiencia local con tiempos de carga ya aceptables, la necesidad de una CDN puede ser mínima.
> 3. Complejidad de Configuración: La configuración y gestión de CloudFront puede ser más compleja que simplemente servir contenido directamente desde un bucket de S3. Esto podría ser innecesario para sitios web muy pequeños y sencillos.
> 4. Requisitos Técnicos: Implementar CloudFront puede requerir conocimientos técnicos adicionales y tiempo para la configuración correcta, lo cual puede no ser ideal si buscas una solución rápida y sencilla.

Conclusión

> Implementar CloudFront en una página web estática pequeña es recomendable si buscas mejorar el rendimiento global, la seguridad y la escalabilidad de tu sitio. Sin embargo, si el sitio tiene un tráfico muy bajo, un presupuesto limitado, o sirve principalmente a una audiencia local con buenos tiempos de carga, los beneficios adicionales de CloudFront pueden no justificar los costos y la complejidad de su implementación.

# Implementación del laboratorio:

Pasos para la implementación:



### GoDaddy

1. Registrar un dominio en internet:
- Dominio registrado en https://account.godaddy.com/products
- Posteriormente cambiaremos los servidores de nombres que vienen por defecto a los que nos ofrece ROUTE 53



### S3

2. Primer servicio de AWS a configurar será el S3
- Vamos a crear un Bucket
- El NOMBRE DEL BUCKET tiene que ser el mismo al nombre del dominio comprado
- Desmarcamos casilla de BLOCK ALL PUBLIC ACCESS debido a que el contenido del bucket estará disponible de forma masiva
- Marcamos la casilla que nos advierte que todo el contenido del bucket estará disponible al público

3. Una vez creado el bucket, ingresamos y guardamos la data
- Seleccionamos la opción de subir
- Arrastramos todos los archivos de nuestra página web estática
- Presionamos el botón de subir

4. Posterior a la subida de nuestros archivos al bucket, vamos a definir el bucket como un sitio web
- Seleccionar la tab de Properties
- Buscamos la opción para editar el static website hosting
- Habilitados la opción
- Definimos el index document, que será index.html
- Guardamos los cambios
- El sitio web ha sido publicado

5. Probamos el endpoint ofrecido por S3
- Vamos a nuestro bucket
- Vamos a la tab de Properties
- Bajamos hasta la sección de Static website hosting
- Presionamos en el endpoint
- El acceso es denegado
- Por qué?

6. Definir un bucket policy de acceso público
- Vamos a la tab de Permissions
- Vemos la sección de Access control list (ACL)
- Vemos que solo el Bucket owner tiene permisos de lectura y escritura sobre el bucket, pero Everyone no tiene ningún acceso
- Vamos a agregar una bucket policy
- Presionamos en editar
- Presionamos en policy generator
- Datos a ingresar:
- - Select type of policy:      S3 BUCKET POLICY
- - Effect:                     ALLOW
- - Principal:                  *
- - Actions:                    GetObject
- - Amazon Resource Name (ARN): arn:aws:s3:::marcolandauro.site/*
                                Agregamos el * al final del nombre el bucket para que todos los objetos sean de acceso público
- Presionamos en Add Statement
- Presionamos en Generate Policy
- Pegamos la policy en el bucket policy section
- Guardamos cambios

7. Probamos el endpoint ofrecido por S3
- Vamos a nuestro bucket
- Vamos a la tab de Properties
- Bajamos hasta la sección de Static website hosting
- Presionamos en el endpoint
- El acceso es aceptado

8. Problema de esta sección:
- Nuestra url no tiene la forma del dominio que compramos, es por ello que comenzaremos a setearlo.



### Route 53

9. Creamos una hosted zone
- Domain name: Nombre del dominio que compramos
- Confirmamos que el tipo sea una zona pública hosteada
- Creamos zona hosteada

10. Una vez creada la zona pública, tendremos dos record names que serán:
Tipo    |   Value
NS      |   4 valores
SOA     |   1 valor
- Amazon nos indica cuáles serán los "servidores de nombres" que va a utilizar para relacionarse con nuestro nombre de dominio.
- En esta sección, tenemos que indicarle a quien hostea nuestros dominios, que quien va a resolver ahora los "servidores de nombres", serán los servidores DNS de AWS 
- Vamos a copiar los 4 servidores de nombre sin el punto final de cada uno.



### GoDaddy.com
11. Cambiar servidores de nombre
- Vamos a cambiar los servidores de nombre predefinidos, con los 4 previamente copiados, y guardamos los cambios
- Qué está pasando ahora?
- el dominio hosteado en godaddy, ahora será administrado por los servicios de dns de aws




### AWS Certificate Manager (ACM)

12. Creación del certificado de seguridad
- Hacemos un request de certificate
- Solicitamos a Amazon un certificado de seguridad público
- Fully qualified domain name: Nombre del dominio que compramos
- Seleccionamos el método de validación por DNS
- Finalizamos el request

13. Revisión del certificado creado
- Vamos a la lista de certificados de ACM
- Presionamos en ver el nuevo certificado que hemos creado
- Nos damos cuenta que el estatus es de validación pendiente.
- Por qué?
Los servicios de ACM tiene que reconocer que verdaderamente vamos a hostear el certificado en el dominio que indicamos.
- Para que suceda eso, tenemos que seleccionar en la sección de dominio, el botón de crear un record en Route 53
- Presionando el botón, automáticamente se va a agregar un registro a Route 53 para indicar que el nombre del dominio corresponde al nombre del sitio web del certificado creado
- Creamos el registro



### Route 53

14. Verificamos que en la zona hosteada creada, se ha agregado el certificado de seguridad
- Vamos a las zonas hosteadas
- Seleccionamos la zona hosteada de nuestro dominio
- Corroboramos que existe un nuevo registro
- qué hace ese registro?
este registro lo usa ACM para dar fe que se está hosteando el certificado de seguridad en el sitio web que se le indicó originalmente a ACM
- En unos minutos ACM va a validar el registro y va a aprovisionar un certificado de seguridad para el sitio



### AWS Certificate Manager (ACM)

15. Validamos que el certificado ha sido aprovado
- Vamos a la lista de certificados y esperamos a que diga Issued en su status



### Amazon CloudFront
 
16. Creamos una distribución de CloudFront
- Origin domain: Nuestro bucket S3 como dice en el escenario
- Viewer: Redirect HTTP to HTTPS
- Web Application Firewall (WAF): Do not enable security protections
- Alternate domain name: Add item: Nuestro nombre de dominio
- Custom SSL certificate - optional: Vamos a seleccionar el certificado creado previamente por ACM
- Default root object: index.html
- Creamos distribución

17. Esperamos el despliegue
- Una vez creada la distribución, tenemos que esperar un tiempo para el despliegue. De qué?
Debido a que CloudFront acerca las páginas web a los distintos usuarios en el mundo, tiene que hacer una replicación de nuestro sitio web en cada edgeLocation





### Route 53

18. Vamos a configurar los servicios de route 53 con nuestro nombre de dominio apuntando a la distribución de cloudfront
- Vamos a nuestra hosted zone
- Creamos un registro
- Record name IGUAL
- Record type: Tipo A
- Marcamos la opción de alias
- Choose endpoint: Alias to cloudFront distribution
- Choose distribution: Nuestra distribución de cloudfront
- Creamos el registro


### Ya podemos probar nuestro sitio web

https://marcolandauro.site/#
https://youtu.be/WyLuqEe6xqA