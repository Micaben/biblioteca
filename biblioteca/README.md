# Biblioteca

API REST para la gestión de una biblioteca desarrollada con Spring Boot.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Lombok
- Maven

## Funcionalidades

- Gestión de usuarios
- Gestión de libros
- Registro de préstamos
- Devolución de libros
- Control automático de stock
- Manejo global de excepciones
- Documentación mediante Swagger

## Arquitectura del proyecto
├── controller
├── service
│ └── impl
├── repository
├── entity
├── dto
│ ├── request
│ ├── response
│ └── mapper
├── exception
└── config


## Configuración de base de datos

El proyecto utiliza PostgreSQL.

Configurar:


application.yaml


con las credenciales correspondientes.

## Ejecutar proyecto

Clonar:


git clone URL_DEL_REPOSITORIO


Ingresar al proyecto:


cd biblioteca


Ejecutar:


mvn spring-boot:run


Servidor:


http://localhost:8080


# Endpoints principales

## Libros

| Método | Endpoint |
|-|-|
| GET | /libros |
| POST | /libros |
| PUT | /libros/{id} |
| DELETE | /libros/{id} |

## Usuarios

| Método | Endpoint |
|-|-|
| GET | /usuarios |
| POST | /usuarios |

## Préstamos

| Método | Endpoint |
|-|-|
| GET | /prestamos |
| POST | /prestamos |
| PUT | /prestamos/{id}/devolver |


## Documentación

Swagger disponible:


http://localhost:8080/swagger-ui/index.html


## Postman

La colección se encuentra en:


postman/Biblioteca_API.postman_collection.json