# 🎬 API REST - Películas

Proyecto final individual de **Ingeniería de Software**: Desarrollo de una API REST con Spring Boot, conectada a una base de datos MySQL, y desplegada mediante Docker Compose.

---

## 📁 Estructura del Proyecto

El repositorio contiene dos componentes principales:

- Carpeta `peliculasapi/`: Código fuente completo del proyecto Spring Boot.
- Archivo `docker-compose.yml`: Archivo de orquestación que permite levantar la base de datos y la API REST en contenedores separados.

### Dentro de `peliculasapi/` encontrarás:

- `entidades`: Definición de la entidad principal `Pelicula`.
- `controladores`: Controlador REST que maneja las peticiones HTTP.
- `repositorios`: Interfaces que permiten interactuar con la base de datos.
- `servicios`: Lógica de negocio para manipular los datos.
- `excepciones`: Manejo de errores personalizados.
- `application.properties`: Configuración de conexión a MySQL.

---

## 🐳 Cómo levantar el proyecto con Docker

### 1. Clona el repositorio

```bash
    git clone https://github.com/betto30/peliculasapi.git
    cd peliculasapi

```genere el distribuible ( .jar ) desde la carpeta del proyecto

      cd peliculasapi\peliculasapi
      mvn clean package

```levante los contenedores en docker

    docker compose up

```acceda al api rest

    http://localhost:8081/api/v1/peliculas/

### Test con Postman

GET http://localhost:8081/api/v1/peliculas/ – Permite obtener todos los datos 

GET http://localhost:8081/api/v1/peliculas/id – Obtiene la pelicula situado en el id seleccionado

POST http://localhost:8081/api/v1/peliculas/ – Permite crear

PUT http://localhost:8081/api/v1/peliculas/id – Edita 

PATCH http://localhost:8081/api/v1/peliculas/id – Actualización parcial

DELETE http://localhost:8081/api/v1/peliculas/id – Elimina 
