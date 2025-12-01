# Examen API REST - Spring Boot

Este proyecto es una **API REST** desarrollada con **Spring Boot** para la gestión integral de un sistema médico, permitiendo la administración de citas, pacientes y sanitarios. Está diseñada siguiendo buenas prácticas de arquitectura en capas, principios SOLID y utilizando tecnologías modernas del ecosistema Java.

## 🚀 Funcionalidades Principales

*   **Gestión de Pacientes**:
    *   Registro, consulta, actualización y eliminación de pacientes.
    *   Almacenamiento persistente en base de datos.
*   **Gestión de Sanitarios**:
    *   Administración de perfiles de médicos y personal sanitario.
*   **Gestión de Citas**:
    *   Creación y programación de citas médicas.
    *   Vinculación entre pacientes y sanitarios.
    *   Búsqueda y cancelación de citas.
*   **Arquitectura Robusta**:
    *   Uso de **DTOs (Data Transfer Objects)** para desacoplar la capa de presentación de la persistencia.
    *   **Manejo Global de Excepciones** para respuestas de error consistentes y amigables.
    *   Validación de datos de entrada.

## 🛠️ Tecnologías Utilizadas

Este proyecto utiliza un stack tecnológico moderno y robusto:

*   **Java 21**: Lenguaje de programación principal, aprovechando las últimas características y mejoras de rendimiento.
*   **Spring Boot 3**: Framework para la creación de aplicaciones stand-alone de grado de producción.
    *   **Spring Data JPA**: Para la capa de persistencia y acceso a datos.
    *   **Spring Web MVC**: Para la construcción de la API RESTful.
*   **Base de Datos**:
    *   **MariaDB**: Base de datos relacional para producción (configurada vía Docker).
    *   **H2**: Base de datos en memoria (opcional para tests rápidos).
*   **Herramientas de Desarrollo**:
    *   **Maven**: Gestión de dependencias y construcción del proyecto.
    *   **Lombok**: Reducción de código repetitivo (boilerplate).
    *   **Docker & Docker Compose**: Orquestación de contenedores para la base de datos y herramientas auxiliares.
    *   **Swagger / OpenAPI**: Documentación interactiva de la API.

## 📂 Estructura del Proyecto

El código fuente está organizado siguiendo una arquitectura de capas clásica:

```
src/main/java/com/agustin/examen
├── config       # Clases de configuración (ej. OpenAPI, Security)
├── controller   # Controladores REST (Entry points de la API)
├── dto          # Objetos de Transferencia de Datos (Request/Response)
├── error        # Manejo global de excepciones y modelos de error
├── model        # Entidades JPA (Mapeo a base de datos)
├── repository   # Interfaces de acceso a datos (Spring Data JPA)
├── service      # Lógica de negocio
└── ExamenApplication.java # Clase principal de arranque
```

## 📋 Prerrequisitos

Asegúrate de tener instalado lo siguiente antes de comenzar:

*   [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
*   [Maven](https://maven.apache.org/)
*   [Docker Desktop](https://www.docker.com/products/docker-desktop/) (para levantar la base de datos)

## 🚀 Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd examen
```

### 2. Levantar la Base de Datos

El proyecto incluye un archivo `docker-compose.yml` para levantar fácilmente una instancia de MariaDB y phpMyAdmin.

```bash
docker-compose up -d
```

Esto iniciará:
*   **MariaDB** en el puerto `3306`.
*   **phpMyAdmin** en el puerto `8081` (acceso vía navegador: `http://localhost:8081`).
    *   **Usuario**: `root`
    *   **Contraseña**: `password123` (definida en `docker-compose.yml` y `application.properties`).

### 3. Configuración de la Aplicación

El archivo `src/main/resources/application.properties` ya viene configurado para conectar con el contenedor de Docker:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/examen
spring.datasource.username=root
spring.datasource.password=password123
spring.jpa.hibernate.ddl-auto=update
server.port=8089
```

### 4. Ejecutar la Aplicación

Puedes ejecutar la aplicación usando Maven:

```bash
./mvnw spring-boot:run
```
o en Windows:
```cmd
mvnw.cmd spring-boot:run
```

La aplicación iniciará en el puerto **8089**.

## 📖 Documentación de la API

Una vez que la aplicación esté corriendo, puedes acceder a la documentación interactiva generada por Swagger/OpenAPI en:

👉 **[http://localhost:8089/swagger-ui.html](http://localhost:8089/swagger-ui.html)**

Desde allí podrás probar todos los endpoints directamente.

## 🤝 Contribución

1.  Haz un Fork del proyecto.
2.  Crea una rama para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3.  Haz Commit de tus cambios (`git commit -m 'Añadir nueva funcionalidad'`).
4.  Haz Push a la rama (`git push origin feature/nueva-funcionalidad`).
5.  Abre un Pull Request.

---
Desarrollado con ❤️ por Agustín.
