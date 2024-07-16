# Paso 3: Elegir uno o más elemento del sistema a refinar

# Diagrama de contexto:
![Diagrama contexto](/proyecto//images/Arquitectura/System%20Context%20diagram.png)

El diagrama de contexto describe la interacción entre la aplicación Atlestat, que gestiona instituciones deportivas de fútbol y analiza estadísticas de jugadores, y varios componentes y usuarios. Los Managers de Institución gestionan equipos y jugadores, realizan pagos de suscripción a través de una API de Servicio de Pagos, y validan su identidad mediante la API Reniec. Los Usuarios de Institución revisan perfiles y estadísticas, mientras que los Usuarios Libres acceden a estadísticas y noticias externas. La API Reniec verifica la identidad de los usuarios, y la API de Servicio de Pagos facilita las transacciones financieras dentro de la aplicación.