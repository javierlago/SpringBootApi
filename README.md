# API REST Liga ACT

Este es un proyecto para crear una API REST con Spring Boot. La API está relacionada con la Asociación de Clubes de Traineras. Con esta API, aparte de practicar con Spring Boot, se pretende crear una manera fácil de manejar los datos de esta asociación como pueden ser los clubes, sus remeros y sus entrenadores.

## Tecnologías Utilizadas ⚙

- **Spring Boot**: Framework principal para el desarrollo de la API. <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
- **Java 17**: Lenguaje de programación utilizado. <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
- **MySQL**: Sistema de gestión de bases de datos utilizado. <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white"/>
- **Spring Data JPA**: Provee la capa de persistencia para interactuar con la base de datos. <img src="https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/>
- **Lombok**: Biblioteca que reduce el código boilerplate mediante anotaciones. <img src="https://img.shields.io/badge/Lombok-BCD32B?style=for-the-badge&logo=Project%20Lombok&logoColor=white"/>

## Funcionalidades 🚀

- Gestión de clubes: Alta, baja, modificación y consulta de clubes.
- Gestión de remeros: Alta, baja, modificación y consulta de remeros asociados a los clubes.
- Gestión de entrenadores: Alta, baja, modificación y consulta de entrenadores asociados a los clubes.

## Instalación y Configuración 📋

### Clonar el repositorio:
```bash
git clone https://github.com/tuusuario/SpringBootApi.git
````


### Configurar la base de datos:

- Instala MySQL si no está instalado.
- Crea una nueva base de datos para la API.

###Configuracion de la conexión a la base de datos:

- Abre el archivo de configuración `application.properties` que se encuentra en la carpeta `src/main/resources`.
  
- Modifica las siguientes líneas con la información correspondiente a tu base de datos:

  
  ```bash
    server.port = 8092 // `Puerto para ver en el navegador el resusltado de la request`
    spring.datasources,driver-class-name = com.mysql.cj.jdbc.Driver // Driver para mysql
    spring.datasource.url = jdbc:mysql://localhost:3306/ligaAct?createDatabaseIfNotExist=true&useSSL=false // nombre de la base de datos
    spring.datasource.username = root // Usuario para conectarse a la base de datos.
    spring.datasource.password = abc123. // Contraseña para el usuario
    spring.jpa.hibernate.ddl-auto=update // Con este parametro nos crea en caso de que no exista las tablas y nos las modifica
    spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect //  Normas con las que se comounicara con MySql

## Uso 🕹

La API expone varios endpoints para gestionar la información de los clubes, remeros y entrenadores. Algunos ejemplos de los endpoints disponibles son:

### Clubes:

- `GET /clubs`: Obtener una lista de todos los clubes.
- `GET /clubs/greater/{yearsInCompetition}`: Obtener una lista de todos los clubes con nas años en competición que el pasado por parametro.
- `GET /clubs/less/{yearsInCompetition}`: Obtener una lista de todos los clubes con menos años en competición que el pasado por parametro.
- `GET /clubs/equal/{yearsInCompetition}`: Obtener una lista de todos los clubes con años en competición a los pasados por parametro.
- `POST /club`: Crear un nuevo club.
- `PUT /club/{id}`: Actualizar la información de un club existente.
- `DELETE /club/{id}`: Eliminar un club.

### Remeros:

- `GET /remeros`: Obtener una lista de todos los remeros.
- `GET /remeros/{idClub}`: Obtener una lista de todos los remeros pertenecientes al club con la id pasada por parametro.
- `POST /remeros`: Crear un nuevo remero.
- `PUT /remeros/{id}`: Actualizar la información de un remero existente.
- `DELETE /remeros/{id}`: Eliminar un remero.

### Entrenadores: 

- `GET /entrenadores`: Obtener una lista de todos los entrenadores.
- `POST /entrenadores`: Crear un nuevo entrenador.
- `PUT /entrenadores/{id}`: Actualizar la información de un entrenador existente.
- `DELETE /entrenadores/{id}`: Eliminar un entrenador.

## Contribución 🤝

Si deseas contribuir a este proyecto, por favor, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios necesarios y haz commit (`git commit -m 'Agrega nueva funcionalidad'`).
4. Envía los cambios a tu repositorio fork (`git push origin feature/nueva-funcionalidad`).
5. Crea un pull request en el repositorio original.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT.



