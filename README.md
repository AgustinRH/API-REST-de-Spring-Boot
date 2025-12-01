# Examen API REST - Spring Boot

Este proyecto es una **API REST** desarrollada con **Spring Boot** para la gestión de citas, pacientes y sanitarios. Está diseñada siguiendo buenas prácticas de arquitectura en capas, utilizando **DTOs**, **Servicios**, **Repositorios JPA** y **Controladores REST**.

## Funcionalidades principales

- **Gestión de pacientes**: CRUD de pacientes con almacenamiento en base de datos.  
- **Gestión de sanitarios**: CRUD de sanitarios y gestión de su información.  
- **Gestión de citas**: Crear, modificar, buscar y eliminar citas vinculadas a pacientes y sanitarios.  
- **DTOs para entradas y salidas**: Simplificación de la comunicación entre cliente y servidor.  
- **Excepciones y manejo de errores**: Control centralizado de errores y respuestas consistentes.  

## Tecnologías utilizadas

- Java 21
- Spring Boot  
- Spring Data JPA  
- H2/MySQL (según configuración en `application.properties`)  
- Maven  

## Estructura del proyecto

- `controller`: Define los endpoints REST para cada entidad.  
- `service`: Lógica de negocio de la aplicación.  
- `repository`: Interfaces JPA para la persistencia de datos.  
- `model`: Clases de entidad que representan las tablas de la base de datos.  
- `dto`: Objetos de transferencia de datos para las operaciones REST.  
- `config & security`: Configuración de la aplicación y seguridad (si aplica).  
- `resources/templates` y `static`: Archivos estáticos y plantillas (si se añaden).  
