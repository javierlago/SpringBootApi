# API REST Liga ACT

Este es un proyecto para crear una API REST con Spring Boot. La API está relacionada con la Asociación de Clubes de Traineras. Con esta API, aparte de practicar con Spring Boot, se pretende crear una manera fácil de manejar los datos de esta asociación como pueden ser los clubes, sus remeros y sus entrenadores.

## Tecnologías Utilizadas ⚙

- **Spring Boot**: Framework principal para el desarrollo de la API.
- **MySQL**: Sistema de gestión de bases de datos utilizado.
- **Spring Data JPA**: Provee la capa de persistencia para interactuar con la base de datos.
- **Lombok**: Biblioteca que reduce el código boilerplate mediante anotaciones.

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

- `GET /clubes`: Obtener una lista de todos los clubes.
- `POST /clubes`: Crear un nuevo club.
- `PUT /clubes/{id}`: Actualizar la información de un club existente.
- `DELETE /clubes/{id}`: Eliminar un club.

### Remeros:

- `GET /remeros`: Obtener una lista de todos los remeros.
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



